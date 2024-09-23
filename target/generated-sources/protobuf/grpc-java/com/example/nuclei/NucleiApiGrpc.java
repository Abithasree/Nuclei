package com.example.nuclei;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NucleiApiGrpc {

  private NucleiApiGrpc() {}

  public static final String SERVICE_NAME = "NucleiApi";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.nuclei.ScanRequest,
      com.example.nuclei.ScanResult> getScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Scan",
      requestType = com.example.nuclei.ScanRequest.class,
      responseType = com.example.nuclei.ScanResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.nuclei.ScanRequest,
      com.example.nuclei.ScanResult> getScanMethod() {
    io.grpc.MethodDescriptor<com.example.nuclei.ScanRequest, com.example.nuclei.ScanResult> getScanMethod;
    if ((getScanMethod = NucleiApiGrpc.getScanMethod) == null) {
      synchronized (NucleiApiGrpc.class) {
        if ((getScanMethod = NucleiApiGrpc.getScanMethod) == null) {
          NucleiApiGrpc.getScanMethod = getScanMethod =
              io.grpc.MethodDescriptor.<com.example.nuclei.ScanRequest, com.example.nuclei.ScanResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Scan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.nuclei.ScanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.nuclei.ScanResult.getDefaultInstance()))
              .setSchemaDescriptor(new NucleiApiMethodDescriptorSupplier("Scan"))
              .build();
        }
      }
    }
    return getScanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NucleiApiStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NucleiApiStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NucleiApiStub>() {
        @java.lang.Override
        public NucleiApiStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NucleiApiStub(channel, callOptions);
        }
      };
    return NucleiApiStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NucleiApiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NucleiApiBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NucleiApiBlockingStub>() {
        @java.lang.Override
        public NucleiApiBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NucleiApiBlockingStub(channel, callOptions);
        }
      };
    return NucleiApiBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NucleiApiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NucleiApiFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NucleiApiFutureStub>() {
        @java.lang.Override
        public NucleiApiFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NucleiApiFutureStub(channel, callOptions);
        }
      };
    return NucleiApiFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NucleiApiImplBase implements io.grpc.BindableService {

    /**
     */
    public void scan(com.example.nuclei.ScanRequest request,
        io.grpc.stub.StreamObserver<com.example.nuclei.ScanResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScanMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.example.nuclei.ScanRequest,
                com.example.nuclei.ScanResult>(
                  this, METHODID_SCAN)))
          .build();
    }
  }

  /**
   */
  public static final class NucleiApiStub extends io.grpc.stub.AbstractAsyncStub<NucleiApiStub> {
    private NucleiApiStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NucleiApiStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NucleiApiStub(channel, callOptions);
    }

    /**
     */
    public void scan(com.example.nuclei.ScanRequest request,
        io.grpc.stub.StreamObserver<com.example.nuclei.ScanResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getScanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NucleiApiBlockingStub extends io.grpc.stub.AbstractBlockingStub<NucleiApiBlockingStub> {
    private NucleiApiBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NucleiApiBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NucleiApiBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.nuclei.ScanResult> scan(
        com.example.nuclei.ScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getScanMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NucleiApiFutureStub extends io.grpc.stub.AbstractFutureStub<NucleiApiFutureStub> {
    private NucleiApiFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NucleiApiFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NucleiApiFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SCAN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NucleiApiImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NucleiApiImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCAN:
          serviceImpl.scan((com.example.nuclei.ScanRequest) request,
              (io.grpc.stub.StreamObserver<com.example.nuclei.ScanResult>) responseObserver);
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

  private static abstract class NucleiApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NucleiApiBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.nuclei.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NucleiApi");
    }
  }

  private static final class NucleiApiFileDescriptorSupplier
      extends NucleiApiBaseDescriptorSupplier {
    NucleiApiFileDescriptorSupplier() {}
  }

  private static final class NucleiApiMethodDescriptorSupplier
      extends NucleiApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NucleiApiMethodDescriptorSupplier(String methodName) {
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
      synchronized (NucleiApiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NucleiApiFileDescriptorSupplier())
              .addMethod(getScanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
