package com.linyf.demo.Throwable;

public class MyException extends Exception {
    public MyException(){}

    public MyException(String msg){
        super(msg);
    }

    public MyException(String msg, Throwable e) {
        super(msg, e);
    }
}
