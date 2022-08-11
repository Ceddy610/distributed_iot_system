package org.iotgateway.data;

import com.fasterxml.jackson.annotation.*;

public class sensorData {
    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("sundensity")
    private String sundensity;

    @JsonProperty("pressure")
    private String pressure;


    public sensorData(String temperature, String humidity, String sundensity, String pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.sundensity = sundensity;
        this.pressure = pressure;
    }

    public sensorData(String temperature, String humidity, String sundensity) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.sundensity = sundensity;
    }

    public sensorData(){}


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSundensity() {
        return sundensity;
    }

    public void setSundensity(String sundensity) {
        this.sundensity = sundensity;
    }

    public void setPressure(String pressure) { this.pressure = pressure; }
}
