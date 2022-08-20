package com.example.simprest.model;


import lombok.Data;

@Data
public class Status {
    private String message;
    private int code;

    public static Status getSuccess(){
        Status status = new Status();
        status.setMessage("SUCCESS");
        status.setCode(200);
        return status;
    }
}
