package org.service;


import io.grpc.stub.StreamObserver;
import org.rpc.Database;
import org.rpc.Database.sensorDataRequest;
import org.rpc.Database.rttDataRequest;
import org.rpc.Database.saveSensorDataResponse;
import org.rpc.Database.saveRttResponse;
import org.rpc.Database.rttDataResponse;
import org.rpc.DatabaseServiceGrpc;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class sensorDataService extends DatabaseServiceGrpc.DatabaseServiceImplBase {



    private final ArrayList<sensorDataRequest> data1 = new ArrayList<>();
    private final ArrayList<sensorDataRequest> data2 = new ArrayList<>();

    private final ArrayList<rttDataRequest> rttData1 = new ArrayList<>();

    private final ArrayList<rttDataRequest> rttData2 = new ArrayList<>();

    @Override
    public void saveSensorData(Database.saveSensorDataRequest request, StreamObserver<Database.saveSensorDataResponse> responseObserver) {
            System.out.println("SAVE SENSOR DATA");

            sensorDataRequest sensorData = request.getSensordata();
            this.data1.add(sensorData);
            saveSensorDataResponse sensorDataResponse = saveSensorDataResponse.newBuilder()
                    .setSensordata(
                            Database.sensorDataResponse.newBuilder()
                                    .setDate(LocalDateTime.now().toString())
                                    .setHumidity(sensorData.getHumidity())
                                    .setTemperature(sensorData.getTemperature())
                                    .setPressure(sensorData.getPressure())
                                    .setSundensity(sensorData.getSundensity())).build();
            responseObserver.onNext(sensorDataResponse);
            responseObserver.onCompleted();
    }

    @Override
    public void saveRtt(Database.saveRttRequest request, StreamObserver<Database.saveRttResponse> responseObserver) {
            System.out.println("SAVE RTT DATA");
            rttDataRequest rttData = request.getRttdata();

            this.rttData1.add(rttData);

            saveRttResponse rttResponse = saveRttResponse.newBuilder()
                    .setRttdata(
                            rttDataResponse.newBuilder()
                                    .setDate(LocalDateTime.now().toString())
                                    .setActiveSensors(rttData.getActiveSensors())
                                    .setRttUdpAverage(rttData.getRttUdpAverage())
                                    .setRttTcpAverage(rttData.getRttTcpAverage())
                                    .setFrequency(rttData.getFrequency()).build()
                    ).build();

            responseObserver.onNext(rttResponse);
            responseObserver.onCompleted();
    }

    @Override
    public void getRtt(Database.getRttRequest request, StreamObserver<Database.getRttResponse> responseObserver) {
            System.out.println("GET RTT DATA");
            rttDataResponse data = this.ArrayToRtt(this.rttData1.get(this.rttData1.size() -1));


            responseObserver.onNext(Database.getRttResponse.newBuilder()
                    .setRttdata(data).build());
            responseObserver.onCompleted();
    }

    @Override
    public void deleteSensorData(Database.deleteSensorDataRequest request, StreamObserver<Database.deleteSensorDataResponse> responseObserver) {
            System.out.println("DELETE SENSOR DATA");
            data1.clear();

            responseObserver.onNext(Database.deleteSensorDataResponse.newBuilder()
                    .setResponse("Sucessfully Deleted").build());
            responseObserver.onCompleted();
    }

    @Override
    public void getSensorData(Database.getSensorDataRequest request, StreamObserver<Database.getSensorDataResponse> responseObserver) {
            System.out.println("GET SENSOR DATA");
            Database.sensorDataResponse data = ArrayToSensorData(this.data1.get(this.data1.size() -1));



            responseObserver.onNext(Database.getSensorDataResponse.newBuilder()
                    .setSensorData(data).build());
            responseObserver.onCompleted();
    }

    private rttDataResponse ArrayToRtt(rttDataRequest request) {
        return rttDataResponse.newBuilder()
                .setDate(LocalDateTime.now().toString())
                .setActiveSensors(request.getActiveSensors())
                .setFrequency(request.getFrequency())
                .setRttTcpAverage(request.getRttTcpAverage())
                .setRttUdpAverage(request.getRttUdpAverage()).build();
    }

    private Database.sensorDataResponse ArrayToSensorData(sensorDataRequest request) {
        return Database.sensorDataResponse.newBuilder()
                .setDate(LocalDateTime.now().toString())
                .setHumidity(request.getHumidity())
                .setTemperature(request.getTemperature())
                .setSundensity(request.getSundensity())
                .setPressure(request.getPressure()).build();
    }
}
