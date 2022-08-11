package org.iotgateway.data;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.UUID;

public class SendRequest implements Serializable {

    private String uuid;

    private String time;
    private String request;


    public SendRequest(String request){
        this.uuid = UUID.randomUUID().toString();
        this.time = LocalTime.now().toString();
        this.request = request;
    }

    public SendRequest(){}

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

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
}
