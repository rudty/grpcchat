package org.rudtyz.grpcchat.message;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.rudtyz.grpcchat.dto.*;

import java.util.concurrent.atomic.AtomicInteger;

@GRpcService
public class MessageService extends MessageGrpc.MessageImplBase {

    private final AtomicInteger messageId = new AtomicInteger();
    private final ClientManager clientManager;

    public MessageService(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    private boolean isCutStatus(Status status) {
        var code = status.getCode();
        return code == Status.Code.CANCELLED ||
                code == Status.Code.ABORTED ||
                code == Status.Code.UNAUTHENTICATED ||
                code == Status.Code.UNKNOWN ||
                code == Status.Code.DEADLINE_EXCEEDED;
    }

    private void broadcastClient(ChatMessageResponse broadcastMessage) {
        synchronized (this) {
            clientManager.forEach(client -> {
                try {
                    client.onNext(broadcastMessage);
                } catch (StatusRuntimeException e) {
                    if (isCutStatus(e.getStatus())) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void broadcastMessage(String message) {
        var chatMessage = ChatMessageResponse.Message.newBuilder()
                .setId(messageId.incrementAndGet())
                .setMessage(message)
                .build();
        var broadcastMessage = ChatMessageResponse.newBuilder()
                .setMessage(chatMessage)
                .build();

        broadcastClient(broadcastMessage);
    }

    @Override
    public void clientBye(IdMessage request, StreamObserver<Empty> responseObserver) {

    }

    @Override
    public StreamObserver<MessageRequest> clientMessage(StreamObserver<ChatMessageResponse> responseObserver) {
        var r = (ServerCallStreamObserver)responseObserver;
        var clientId = clientManager.addClient(r);

        return new StreamObserver<MessageRequest>() {
            @Override
            public void onNext(MessageRequest value) {
                String message = value.getMessage();
                broadcastMessage(message);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t);
//                clientManager.removeClient(clientId);
            }

            @Override
            public void onCompleted() {
//                clientManager.removeClient(clientId);
            }
        };
    }
}
