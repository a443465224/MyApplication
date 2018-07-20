package com.example.administrator.myapplication.bean;

/**
 * Created by XDH on 2018/5/4.
 */
public class ApiException extends RuntimeException {

    public ApiException(String msg) {
        super(msg);
    }
}
