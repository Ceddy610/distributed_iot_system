package org.iotgateway.data;


import com.fasterxml.jackson.annotation.*;

public class ReplyData {
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("time")
    private String time;

    @JsonProperty("sensorData")
    private sensorData sensorData;



    public ReplyData(String uuid, String time, sensorData sensorData) {
        this.uuid = uuid;
        this.time = time;
        this.sensorData = sensorData;
    }

    public ReplyData(){}


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public sensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(sensorData sensorData) {
        this.sensorData = sensorData;
    }
}

