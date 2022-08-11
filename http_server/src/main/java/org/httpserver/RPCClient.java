package org.httpserver;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.httpserver.models.RttDataModel;
import org.httpserver.models.SensorDataModel;
import org.rpc.Database;
import org.rpc.DatabaseServiceGrpc;

import java.util.Objects;

public class RPCClient{
    ManagedChannel channel;

    DatabaseServiceGrpc.DatabaseServiceBlockingStub stub;

    public RPCClient(int port, String name) {
        this.channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
    }

    public String sendSensorData(SensorDataModel sensorData) {
            this.stub = DatabaseServiceGrpc.newBlockingStub(this.channel);
            Database.sensorData.Builder data;
            if(Objects.equals(sensorData.getPressure(), "")){
                data = Database.sensorData.newBuilder()
                        .setTemperature(sensorData.getTemperature())
                        .setHumidity(sensorData.getHumidity())
                        .setSundensity(sensorData.getSundensity());
            } else {
                data = Database.sensorData.newBuilder()
                        .setTemperature(sensorData.getTemperature())
                        .setPressure(sensorData.getPressure())
                        .setHumidity(sensorData.getHumidity())
                        .setSundensity(sensorData.getSundensity());
            }


            Database.saveSensorDataRequest sensorDataRequest = Database.saveSensorDataRequest.newBuilder().setSensordata(data).build();
            Database.saveSensorDataResponse response = this.stub.saveSensorData(sensorDataRequest);

            return ("ADDED NEW ENTRY TO DATABASE" + " " + response.getSensordata());
    }

    public Database.sensorDataResponse getSensorData() {
            this.stub = DatabaseServiceGrpc.newBlockingStub(this.channel);
            Database.getSensorDataRequest sensorDataRequest = Database.getSensorDataRequest.newBuilder().build();

            Database.getSensorDataResponse response = this.stub.getSensorData(sensorDataRequest);

            return response.getSensordata();
    }

    public String deleteSensorData() {
            this.stub = DatabaseServiceGrpc.newBlockingStub(this.channel);
            Database.deleteSensorDataRequest deleteSensorDataRequest = Database.deleteSensorDataRequest.newBuilder().build();

            Database.deleteSensorDataResponse response = this.stub.deleteSensorData(deleteSensorDataRequest);

            return response.getResponse();
    }

    public String sendRttData(RttDataModel rttData) {
            this.stub = DatabaseServiceGrpc.newBlockingStub(this.channel);
            Database.rttData.Builder data = Database.rttData.newBuilder()
                    .setActiveSensors(rttData.getActiveSensors())
                    .setRttTcpAverage(rttData.getRttTcpAverage())
                    .setRttUdpAverage(rttData.getRttUdpAverage())
                    .setFrequency(rttData.getFrequency());

            Database.saveRttRequest rttRequest = Database.saveRttRequest.newBuilder().setRttdata(data).build();
            Database.rttDataResponse response = this.stub.saveRtt(rttRequest);

            return response.toString();
    }

    public String getRttData() {
            this.stub = DatabaseServiceGrpc.newBlockingStub(this.channel);
            Database.getRttRequest rttRequest = Database.getRttRequest.newBuilder().build();

            Database.rttDataResponse response = this.stub.getRtt(rttRequest);


            return response.toString();
    }

}
