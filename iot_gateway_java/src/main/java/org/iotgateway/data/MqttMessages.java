package org.iotgateway.data;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MqttMessages {

    @JsonProperty("messages")
    String messages;


    public MqttMessages(){
    }

    public void setmqttMessages(String messages) {
        this.messages = messages;
    }


    public String getmqttMessages() {
        return messages;
    }
}