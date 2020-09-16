package org.rudtyz.grpcchat.message;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.rudtyz.grpcchat.dto.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@GRpcService
public class MessageService extends MessageGrpc.MessageImplBase {

    AtomicInteger clientId = new AtomicInteger();
    AtomicInteger messageId = new AtomicInteger();
    HashMap<Integer, StreamObserver<ReceiveReply>> observers = new HashMap<>();

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


        LinkedList<Integer> errorClients = new LinkedList<>();

        for (var kv : observers.entrySet()) {
            var clientId = kv.getKey();
            var responseObserver = kv.getValue();
            try {
                responseObserver.onNext(broadcastMessage);
            } catch (StatusRuntimeException e) {
                if (isCutStatus(e.getStatus())) {
                    errorClients.add(clientId);
                }
            }
        }

        for (var k : errorClients) {
            observers.remove(k);
        }
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
        observers.put(clientId.incrementAndGet(), responseObserver);
    }

}
