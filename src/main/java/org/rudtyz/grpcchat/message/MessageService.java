package org.rudtyz.grpcchat.message;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.rudtyz.grpcchat.dto.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@GRpcService
public class MessageService extends MessageGrpc.MessageImplBase {

    private final ClientManager clientManager;
    private final AtomicInteger messageId = new AtomicInteger();

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

    private void broadcastMessage(String message) {
        var broadcastMessage = ReceiveReply.newBuilder()
                .setMessage(message)
                .build();

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

    @Override
    public synchronized void clientSend(SendRequest request, StreamObserver<SendReply> responseObserver) {
        broadcastMessage(request.getMessage());

        responseObserver.onNext(
                SendReply.newBuilder()
                        .setMessageId(messageId.incrementAndGet())
                        .build());
        responseObserver.onCompleted();

    }

    @Override
    public synchronized void clientReceive(Empty request, StreamObserver<ReceiveReply> responseObserver) {
        // 기본 구현 StreamObserver<ReceiveReply> 으로는
        // 클라이언트와 연결이 종료될 시 알 수가 없어서
        var res = (ServerCallStreamObserver<ReceiveReply>) responseObserver;
        clientManager.addClient(res);
    }

}
