package com.linyf.demo.reflectSingleBug;

import java.io.Serializable;

public class SingletonDemo1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final SingletonDemo1 singletonDemo = null;

    private SingletonDemo1(){}

    public static SingletonDemo1 getInstance(){
        if(singletonDemo==null){
            return new SingletonDemo1();
        }
        return singletonDemo;
    }
}
