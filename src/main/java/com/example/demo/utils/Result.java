package com.example.demo.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public Result(int status,String msg){
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    public void setResult(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
