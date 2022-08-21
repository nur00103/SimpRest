package com.example.simprest.model;


import lombok.Data;

@Data
public class Status {
    private String message;
    private int code;

    public static Status getSuccessSave(){
        Status status = new Status();
        status.setMessage("Data has been added to the database");
        status.setCode(210);
        return status;
    }
    public static Status getSuccessList(){
        Status status = new Status();
        status.setMessage("Data has been obtained from database");
        status.setCode(220);
        return status;
    }
    public static Status getSuccessDelete(){
        Status status = new Status();
        status.setMessage("Data has been deleted");
        status.setCode(230);
        return status;
    }
    public static Status getSuccessUpdate(){
        Status status = new Status();
        status.setMessage("Data has been updated");
        status.setCode(240);
        return status;
    }
    public static Status getSuccess(){
        Status status = new Status();
        status.setMessage("SUCCESS");
        status.setCode(200);
        return status;
    }

}
