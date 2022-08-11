package org.iotgateway.data;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PressureData {

    @JsonProperty("pressure")
    String pressure;


    public PressureData(){
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


    public String getPressure() {
        return pressure;
    }
}
