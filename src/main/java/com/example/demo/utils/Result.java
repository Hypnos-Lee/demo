package com.example.demo.utils;

import java.io.Serializable;

public class Result implements Serializable {
    private int status;
    private String msg;

    public Result(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public void setStatusAndMsg(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus() {
        return status;
    }
}
