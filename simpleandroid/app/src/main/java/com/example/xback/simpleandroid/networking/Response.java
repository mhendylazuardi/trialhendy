package com.example.xback.simpleandroid.networking;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by retrofit"})
    public Response(){
    }

    public Response(String status){
        this.status = status;
    }
}
