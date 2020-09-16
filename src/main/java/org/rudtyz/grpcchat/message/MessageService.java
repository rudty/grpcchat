package org.rudtyz.grpcchat.message;

import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.rudtyz.grpcchat.dto.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@GRpcService
public class MessageService extends MessageGrpc.MessageImplBase {

    AtomicInteger clientId = new AtomicInteger();
    AtomicInteger messageId = new AtomicInteger();
    HashMap<Integer, StreamObserver<ReceiveReply>> observers = new HashMap<>();

    @Override
    public void clientSend(SendRequest request, StreamObserver<SendReply> responseObserver) {
        var broadcastMessage = ReceiveReply.newBuilder()
               .setMessage(request.getMessage())
               .build();
        observers.forEach((k, v) -> {
            try {
                v.onNext(broadcastMessage);
            } catch (StatusRuntimeException e) {
                observers.remove(k);
            }
        });

        responseObserver.onNext(
                SendReply.newBuilder()
                        .setMessageId(messageId.incrementAndGet())
                        .build());

    }

    @Override
    public synchronized void clientReceive(Empty request, StreamObserver<ReceiveReply> responseObserver) {
        observers.put(clientId.incrementAndGet(), responseObserver);
    }

}
