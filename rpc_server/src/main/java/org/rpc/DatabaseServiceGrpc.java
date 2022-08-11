package org.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: database.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DatabaseServiceGrpc {

  private DatabaseServiceGrpc() {}

  public static final String SERVICE_NAME = "org.rpc.DatabaseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.rpc.Database.saveSensorDataRequest,
      org.rpc.Database.saveSensorDataResponse> getSaveSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveSensorData",
      requestType = org.rpc.Database.saveSensorDataRequest.class,
      responseType = org.rpc.Database.saveSensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rpc.Database.saveSensorDataRequest,
      org.rpc.Database.saveSensorDataResponse> getSaveSensorDataMethod() {
    io.grpc.MethodDescriptor<org.rpc.Database.saveSensorDataRequest, org.rpc.Database.saveSensorDataResponse> getSaveSensorDataMethod;
    if ((getSaveSensorDataMethod = DatabaseServiceGrpc.getSaveSensorDataMethod) == null) {
      synchronized (DatabaseServiceGrpc.class) {
        if ((getSaveSensorDataMethod = DatabaseServiceGrpc.getSaveSensorDataMethod) == null) {
          DatabaseServiceGrpc.getSaveSensorDataMethod = getSaveSensorDataMethod =
              io.grpc.MethodDescriptor.<org.rpc.Database.saveSensorDataRequest, org.rpc.Database.saveSensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.saveSensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.saveSensorDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseServiceMethodDescriptorSupplier("saveSensorData"))
              .build();
        }
      }
    }
    return getSaveSensorDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.rpc.Database.getSensorDataRequest,
      org.rpc.Database.getSensorDataResponse> getGetSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSensorData",
      requestType = org.rpc.Database.getSensorDataRequest.class,
      responseType = org.rpc.Database.getSensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rpc.Database.getSensorDataRequest,
      org.rpc.Database.getSensorDataResponse> getGetSensorDataMethod() {
    io.grpc.MethodDescriptor<org.rpc.Database.getSensorDataRequest, org.rpc.Database.getSensorDataResponse> getGetSensorDataMethod;
    if ((getGetSensorDataMethod = DatabaseServiceGrpc.getGetSensorDataMethod) == null) {
      synchronized (DatabaseServiceGrpc.class) {
        if ((getGetSensorDataMethod = DatabaseServiceGrpc.getGetSensorDataMethod) == null) {
          DatabaseServiceGrpc.getGetSensorDataMethod = getGetSensorDataMethod =
              io.grpc.MethodDescriptor.<org.rpc.Database.getSensorDataRequest, org.rpc.Database.getSensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.getSensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.getSensorDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseServiceMethodDescriptorSupplier("getSensorData"))
              .build();
        }
      }
    }
    return getGetSensorDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.rpc.Database.deleteSensorDataRequest,
      org.rpc.Database.deleteSensorDataResponse> getDeleteSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteSensorData",
      requestType = org.rpc.Database.deleteSensorDataRequest.class,
      responseType = org.rpc.Database.deleteSensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rpc.Database.deleteSensorDataRequest,
      org.rpc.Database.deleteSensorDataResponse> getDeleteSensorDataMethod() {
    io.grpc.MethodDescriptor<org.rpc.Database.deleteSensorDataRequest, org.rpc.Database.deleteSensorDataResponse> getDeleteSensorDataMethod;
    if ((getDeleteSensorDataMethod = DatabaseServiceGrpc.getDeleteSensorDataMethod) == null) {
      synchronized (DatabaseServiceGrpc.class) {
        if ((getDeleteSensorDataMethod = DatabaseServiceGrpc.getDeleteSensorDataMethod) == null) {
          DatabaseServiceGrpc.getDeleteSensorDataMethod = getDeleteSensorDataMethod =
              io.grpc.MethodDescriptor.<org.rpc.Database.deleteSensorDataRequest, org.rpc.Database.deleteSensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.deleteSensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.deleteSensorDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseServiceMethodDescriptorSupplier("deleteSensorData"))
              .build();
        }
      }
    }
    return getDeleteSensorDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.rpc.Database.saveRttRequest,
      org.rpc.Database.saveRttResponse> getSaveRttMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveRtt",
      requestType = org.rpc.Database.saveRttRequest.class,
      responseType = org.rpc.Database.saveRttResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rpc.Database.saveRttRequest,
      org.rpc.Database.saveRttResponse> getSaveRttMethod() {
    io.grpc.MethodDescriptor<org.rpc.Database.saveRttRequest, org.rpc.Database.saveRttResponse> getSaveRttMethod;
    if ((getSaveRttMethod = DatabaseServiceGrpc.getSaveRttMethod) == null) {
      synchronized (DatabaseServiceGrpc.class) {
        if ((getSaveRttMethod = DatabaseServiceGrpc.getSaveRttMethod) == null) {
          DatabaseServiceGrpc.getSaveRttMethod = getSaveRttMethod =
              io.grpc.MethodDescriptor.<org.rpc.Database.saveRttRequest, org.rpc.Database.saveRttResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveRtt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.saveRttRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.saveRttResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseServiceMethodDescriptorSupplier("saveRtt"))
              .build();
        }
      }
    }
    return getSaveRttMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.rpc.Database.getRttRequest,
      org.rpc.Database.getRttResponse> getGetRttMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRtt",
      requestType = org.rpc.Database.getRttRequest.class,
      responseType = org.rpc.Database.getRttResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.rpc.Database.getRttRequest,
      org.rpc.Database.getRttResponse> getGetRttMethod() {
    io.grpc.MethodDescriptor<org.rpc.Database.getRttRequest, org.rpc.Database.getRttResponse> getGetRttMethod;
    if ((getGetRttMethod = DatabaseServiceGrpc.getGetRttMethod) == null) {
      synchronized (DatabaseServiceGrpc.class) {
        if ((getGetRttMethod = DatabaseServiceGrpc.getGetRttMethod) == null) {
          DatabaseServiceGrpc.getGetRttMethod = getGetRttMethod =
              io.grpc.MethodDescriptor.<org.rpc.Database.getRttRequest, org.rpc.Database.getRttResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRtt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.getRttRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.rpc.Database.getRttResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseServiceMethodDescriptorSupplier("getRtt"))
              .build();
        }
      }
    }
    return getGetRttMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DatabaseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceStub>() {
        @java.lang.Override
        public DatabaseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatabaseServiceStub(channel, callOptions);
        }
      };
    return DatabaseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatabaseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceBlockingStub>() {
        @java.lang.Override
        public DatabaseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatabaseServiceBlockingStub(channel, callOptions);
        }
      };
    return DatabaseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DatabaseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatabaseServiceFutureStub>() {
        @java.lang.Override
        public DatabaseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatabaseServiceFutureStub(channel, callOptions);
        }
      };
    return DatabaseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DatabaseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void saveSensorData(org.rpc.Database.saveSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.saveSensorDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveSensorDataMethod(), responseObserver);
    }

    /**
     */
    public void getSensorData(org.rpc.Database.getSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.getSensorDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSensorDataMethod(), responseObserver);
    }

    /**
     */
    public void deleteSensorData(org.rpc.Database.deleteSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.deleteSensorDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSensorDataMethod(), responseObserver);
    }

    /**
     */
    public void saveRtt(org.rpc.Database.saveRttRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.saveRttResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveRttMethod(), responseObserver);
    }

    /**
     */
    public void getRtt(org.rpc.Database.getRttRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.getRttResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRttMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveSensorDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.rpc.Database.saveSensorDataRequest,
                org.rpc.Database.saveSensorDataResponse>(
                  this, METHODID_SAVE_SENSOR_DATA)))
          .addMethod(
            getGetSensorDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.rpc.Database.getSensorDataRequest,
                org.rpc.Database.getSensorDataResponse>(
                  this, METHODID_GET_SENSOR_DATA)))
          .addMethod(
            getDeleteSensorDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.rpc.Database.deleteSensorDataRequest,
                org.rpc.Database.deleteSensorDataResponse>(
                  this, METHODID_DELETE_SENSOR_DATA)))
          .addMethod(
            getSaveRttMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.rpc.Database.saveRttRequest,
                org.rpc.Database.saveRttResponse>(
                  this, METHODID_SAVE_RTT)))
          .addMethod(
            getGetRttMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.rpc.Database.getRttRequest,
                org.rpc.Database.getRttResponse>(
                  this, METHODID_GET_RTT)))
          .build();
    }
  }

  /**
   */
  public static final class DatabaseServiceStub extends io.grpc.stub.AbstractAsyncStub<DatabaseServiceStub> {
    private DatabaseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseServiceStub(channel, callOptions);
    }

    /**
     */
    public void saveSensorData(org.rpc.Database.saveSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.saveSensorDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveSensorDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSensorData(org.rpc.Database.getSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.getSensorDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSensorDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSensorData(org.rpc.Database.deleteSensorDataRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.deleteSensorDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSensorDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveRtt(org.rpc.Database.saveRttRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.saveRttResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveRttMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRtt(org.rpc.Database.getRttRequest request,
        io.grpc.stub.StreamObserver<org.rpc.Database.getRttResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRttMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DatabaseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DatabaseServiceBlockingStub> {
    private DatabaseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.rpc.Database.saveSensorDataResponse saveSensorData(org.rpc.Database.saveSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveSensorDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.rpc.Database.getSensorDataResponse getSensorData(org.rpc.Database.getSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSensorDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.rpc.Database.deleteSensorDataResponse deleteSensorData(org.rpc.Database.deleteSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSensorDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.rpc.Database.saveRttResponse saveRtt(org.rpc.Database.saveRttRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveRttMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.rpc.Database.getRttResponse getRtt(org.rpc.Database.getRttRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRttMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DatabaseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DatabaseServiceFutureStub> {
    private DatabaseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rpc.Database.saveSensorDataResponse> saveSensorData(
        org.rpc.Database.saveSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveSensorDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rpc.Database.getSensorDataResponse> getSensorData(
        org.rpc.Database.getSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSensorDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rpc.Database.deleteSensorDataResponse> deleteSensorData(
        org.rpc.Database.deleteSensorDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSensorDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rpc.Database.saveRttResponse> saveRtt(
        org.rpc.Database.saveRttRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveRttMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.rpc.Database.getRttResponse> getRtt(
        org.rpc.Database.getRttRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRttMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_SENSOR_DATA = 0;
  private static final int METHODID_GET_SENSOR_DATA = 1;
  private static final int METHODID_DELETE_SENSOR_DATA = 2;
  private static final int METHODID_SAVE_RTT = 3;
  private static final int METHODID_GET_RTT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatabaseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatabaseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_SENSOR_DATA:
          serviceImpl.saveSensorData((org.rpc.Database.saveSensorDataRequest) request,
              (io.grpc.stub.StreamObserver<org.rpc.Database.saveSensorDataResponse>) responseObserver);
          break;
        case METHODID_GET_SENSOR_DATA:
          serviceImpl.getSensorData((org.rpc.Database.getSensorDataRequest) request,
              (io.grpc.stub.StreamObserver<org.rpc.Database.getSensorDataResponse>) responseObserver);
          break;
        case METHODID_DELETE_SENSOR_DATA:
          serviceImpl.deleteSensorData((org.rpc.Database.deleteSensorDataRequest) request,
              (io.grpc.stub.StreamObserver<org.rpc.Database.deleteSensorDataResponse>) responseObserver);
          break;
        case METHODID_SAVE_RTT:
          serviceImpl.saveRtt((org.rpc.Database.saveRttRequest) request,
              (io.grpc.stub.StreamObserver<org.rpc.Database.saveRttResponse>) responseObserver);
          break;
        case METHODID_GET_RTT:
          serviceImpl.getRtt((org.rpc.Database.getRttRequest) request,
              (io.grpc.stub.StreamObserver<org.rpc.Database.getRttResponse>) responseObserver);
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

  private static abstract class DatabaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatabaseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.rpc.Database.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatabaseService");
    }
  }

  private static final class DatabaseServiceFileDescriptorSupplier
      extends DatabaseServiceBaseDescriptorSupplier {
    DatabaseServiceFileDescriptorSupplier() {}
  }

  private static final class DatabaseServiceMethodDescriptorSupplier
      extends DatabaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DatabaseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DatabaseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DatabaseServiceFileDescriptorSupplier())
              .addMethod(getSaveSensorDataMethod())
              .addMethod(getGetSensorDataMethod())
              .addMethod(getDeleteSensorDataMethod())
              .addMethod(getSaveRttMethod())
              .addMethod(getGetRttMethod())
              .build();
        }
      }
    }
    return result;
  }
}
