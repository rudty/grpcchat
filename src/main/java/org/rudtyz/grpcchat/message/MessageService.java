package org.rudtyz.grpcchat.message;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.rudtyz.grpcchat.dto.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageService extends MessageGrpc.MessageImplBase {

    AtomicInteger messageId = new AtomicInteger();
    ArrayList<StreamObserver<ReceiveReply>> observers = new ArrayList<>();

    @Override
    public void clientSend(SendRequest request, StreamObserver<SendReply> responseObserver) {
        var broadcastMessage = ReceiveReply.newBuilder()
               .setMessage(request.getMessage())
               .build();
        observers.forEach(e -> e.onNext(broadcastMessage));

        responseObserver.onNext(
                SendReply.newBuilder()
                        .setMessageId(messageId.incrementAndGet())
                        .build());

    }

    @Override
    public synchronized void clientReceive(Empty request, StreamObserver<ReceiveReply> responseObserver) {
        observers.add(responseObserver);
    }

}
