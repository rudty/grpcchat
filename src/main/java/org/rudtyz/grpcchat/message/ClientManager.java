package org.rudtyz.grpcchat.message;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Component
public class ClientManager {
    /**
     * 클라이언트가 입장할때마다 새 클라이언트를 만들어서 전달
     */
    private final AtomicInteger clientId = new AtomicInteger();

    /**
     * 클라이언트 보관용
     */
    private final HashMap<Integer, ServerCallStreamObserver> clients = new HashMap<>();

    /**
     * 여기에 등록된 클라이언트 아이디는 다음에 forEach 호출 시 clients 에서 제거됨
     */
    private final HashSet<Integer> removeNextIds = new HashSet<>();

    private class ClientDisconnectHandler implements Runnable {
        private int clientId;
        private ServerCallStreamObserver client;

        public ClientDisconnectHandler(int clientId, ServerCallStreamObserver client) {
            this.clientId = clientId;
            this.client = client;
        }

        @Override
        public void run() {
            removeClient(clientId);
        }
    }

    /**
     * 클라이언트를 제거합니다
     * @param clientId 제거할 클라이언트의 아이디
     */
    public synchronized void removeClient(int clientId) {
        removeNextIds.add(clientId);
    }

    private boolean isCutStatus(Status status) {
        var code = status.getCode();
        return code == Status.Code.CANCELLED ||
                code == Status.Code.ABORTED ||
                code == Status.Code.UNAUTHENTICATED ||
                code == Status.Code.UNKNOWN ||
                code == Status.Code.DEADLINE_EXCEEDED;
    }


    /**
     * client manager 에 새로운 클라이언트를 등록합니다.
     *
     * @param client grpc client
     * @return 클라이언트의 아이디
     */
    public int addClient(StreamObserver client) {
        var r = (ServerCallStreamObserver) client;
        return addClient(r);
    }

    /**
     * client manager 에 새로운 클라이언트를 등록합니다.
     *
     * @param client grpc client
     * @return 클라이언트의 아이디
     */
    public int addClient(ServerCallStreamObserver client) {
        var newId = clientId.incrementAndGet();
        synchronized (this) {
            clients.put(newId, client);
        }
        client.setOnCancelHandler(new ClientDisconnectHandler(newId, client));
        return newId;
    }

    /**
     * 클라이언트 모두에게 어떤 작업을 실행합니다.
     *
     * @param f 실행할 작업
     */
    public <T> void forEach(Consumer<ServerCallStreamObserver<T>> f) {
        synchronized (this) {
            for (var removeClientId : removeNextIds) {
                clients.remove(removeClientId);
            }
            clients.forEach((k, v) -> {
                try {
                    f.accept(v);
                } catch (StatusRuntimeException e) {
                    if (isCutStatus(e.getStatus())) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
