package org.rudtyz.grpcchat.message;

import io.grpc.stub.ServerCallStreamObserver;
import org.rudtyz.grpcchat.dto.ReceiveReply;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Component
public class ClientManager {
    private AtomicInteger clientId = new AtomicInteger();
    private HashMap<Integer, ServerCallStreamObserver<ReceiveReply>> clients = new HashMap<>();

    class ClientDisconnectHandler implements Runnable {
        private int clientId;
        private ServerCallStreamObserver<ReceiveReply> client;

        public ClientDisconnectHandler(int clientId, ServerCallStreamObserver<ReceiveReply> client) {
            this.clientId = clientId;
            this.client = client;
        }

        @Override
        public void run() {
            synchronized (ClientManager.this) {
                clients.remove(clientId);
            }
        }
    }

    /**
     * client manager 에 새로운 클라이언트를 등록합니다.
     * @param client grpc client
     * @return 클라이언트의 아이디
     */
    public int addClient(ServerCallStreamObserver<ReceiveReply> client) {
        var newId = clientId.incrementAndGet();
        clients.put(newId, client);
        client.setOnCancelHandler(new ClientDisconnectHandler(newId, client));
        return newId;
    }

    /**
     * 클라이언트 모두에게 어떤 작업을 실행합니다.
     * @param f 실행할 작업
     */
    public void forEach(Consumer<ServerCallStreamObserver<ReceiveReply>> f) {
        synchronized (this) {
            clients.forEach((k, v) -> f.accept(v));
        }
    }
}
