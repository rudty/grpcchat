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

    private synchronized void broadcastClient(ChatMessageResponse broadcastMessage) {
        clientManager.forEach(client -> client.onNext(broadcastMessage));
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

    private void broadcastHello(int clientId) {
        var hello = ChatMessageResponse.Hello.newBuilder()
                .setId(clientId)
                .build();

        var broadcastMessage = ChatMessageResponse.newBuilder()
                .setHello(hello)
                .build();

        broadcastClient(broadcastMessage);
    }

    @Override
    public void clientBye(IdMessage request, StreamObserver<Empty> responseObserver) {
        clientManager.removeClient(request.getId());
    }

    @Override
    public StreamObserver<MessageRequest> clientMessage(StreamObserver<ChatMessageResponse> responseObserver) {
        var clientId = clientManager.addClient(responseObserver);
        broadcastHello(clientId);
        return new StreamObserver<MessageRequest>() {
            @Override
            public void onNext(MessageRequest value) {
                String message = value.getMessage();
                broadcastMessage(clientId + " " + message);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t);
//                clientManager.removeClient(clientId);
            }

            @Override
            public void onCompleted() {
                System.out.println("complete");
//                clientManager.removeClient(clientId);
            }
        };
    }
}
