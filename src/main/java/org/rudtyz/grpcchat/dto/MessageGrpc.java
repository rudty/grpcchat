package org.rudtyz.grpcchat.dto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: chat.proto")
public final class MessageGrpc {

  private MessageGrpc() {}

  public static final String SERVICE_NAME = "message.Message";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.rudtyz.grpcchat.dto.SendRequest,
      org.rudtyz.grpcchat.dto.SendReply> getClientSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientSend",
      requestType = org.rudtyz.grpcchat.dto.SendRequest.class,
      responseType = org.rudtyz.grpcchat.dto.SendReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rudtyz.grpcchat.dto.SendRequest,
      org.rudtyz.grpcchat.dto.SendReply> getClientSendMethod() {
    io.grpc.MethodDescriptor<org.rudtyz.grpcchat.dto.SendRequest, org.rudtyz.grpcchat.dto.SendReply> getClientSendMethod;
    if ((getClientSendMethod = MessageGrpc.getClientSendMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getClientSendMethod = MessageGrpc.getClientSendMethod) == null) {
          MessageGrpc.getClientSendMethod = getClientSendMethod =
              io.grpc.MethodDescriptor.<org.rudtyz.grpcchat.dto.SendRequest, org.rudtyz.grpcchat.dto.SendReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClientSend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rudtyz.grpcchat.dto.SendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rudtyz.grpcchat.dto.SendReply.getDefaultInstance()))
              .setSchemaDescriptor(new MessageMethodDescriptorSupplier("ClientSend"))
              .build();
        }
      }
    }
    return getClientSendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.rudtyz.grpcchat.dto.ReceiveReply> getClientReceiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientReceive",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.rudtyz.grpcchat.dto.ReceiveReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.rudtyz.grpcchat.dto.ReceiveReply> getClientReceiveMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.rudtyz.grpcchat.dto.ReceiveReply> getClientReceiveMethod;
    if ((getClientReceiveMethod = MessageGrpc.getClientReceiveMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getClientReceiveMethod = MessageGrpc.getClientReceiveMethod) == null) {
          MessageGrpc.getClientReceiveMethod = getClientReceiveMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.rudtyz.grpcchat.dto.ReceiveReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClientReceive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rudtyz.grpcchat.dto.ReceiveReply.getDefaultInstance()))
              .setSchemaDescriptor(new MessageMethodDescriptorSupplier("ClientReceive"))
              .build();
        }
      }
    }
    return getClientReceiveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageStub>() {
        @java.lang.Override
        public MessageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageStub(channel, callOptions);
        }
      };
    return MessageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub>() {
        @java.lang.Override
        public MessageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageBlockingStub(channel, callOptions);
        }
      };
    return MessageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub>() {
        @java.lang.Override
        public MessageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageFutureStub(channel, callOptions);
        }
      };
    return MessageFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class MessageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void clientSend(org.rudtyz.grpcchat.dto.SendRequest request,
        io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.SendReply> responseObserver) {
      asyncUnimplementedUnaryCall(getClientSendMethod(), responseObserver);
    }

    /**
     */
    public void clientReceive(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.ReceiveReply> responseObserver) {
      asyncUnimplementedUnaryCall(getClientReceiveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getClientSendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.rudtyz.grpcchat.dto.SendRequest,
                org.rudtyz.grpcchat.dto.SendReply>(
                  this, METHODID_CLIENT_SEND)))
          .addMethod(
            getClientReceiveMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.rudtyz.grpcchat.dto.ReceiveReply>(
                  this, METHODID_CLIENT_RECEIVE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MessageStub extends io.grpc.stub.AbstractAsyncStub<MessageStub> {
    private MessageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void clientSend(org.rudtyz.grpcchat.dto.SendRequest request,
        io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.SendReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClientSendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clientReceive(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.ReceiveReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getClientReceiveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MessageBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessageBlockingStub> {
    private MessageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public org.rudtyz.grpcchat.dto.SendReply clientSend(org.rudtyz.grpcchat.dto.SendRequest request) {
      return blockingUnaryCall(
          getChannel(), getClientSendMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.rudtyz.grpcchat.dto.ReceiveReply> clientReceive(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getClientReceiveMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MessageFutureStub extends io.grpc.stub.AbstractFutureStub<MessageFutureStub> {
    private MessageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rudtyz.grpcchat.dto.SendReply> clientSend(
        org.rudtyz.grpcchat.dto.SendRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClientSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CLIENT_SEND = 0;
  private static final int METHODID_CLIENT_RECEIVE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_SEND:
          serviceImpl.clientSend((org.rudtyz.grpcchat.dto.SendRequest) request,
              (io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.SendReply>) responseObserver);
          break;
        case METHODID_CLIENT_RECEIVE:
          serviceImpl.clientReceive((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.rudtyz.grpcchat.dto.ReceiveReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.rudtyz.grpcchat.dto.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Message");
    }
  }

  private static final class MessageFileDescriptorSupplier
      extends MessageBaseDescriptorSupplier {
    MessageFileDescriptorSupplier() {}
  }

  private static final class MessageMethodDescriptorSupplier
      extends MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFileDescriptorSupplier())
              .addMethod(getClientSendMethod())
              .addMethod(getClientReceiveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
