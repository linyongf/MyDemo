package com.linyf.demo.reflectSingleBug;

import java.io.Serializable;

public class SingletonDemo implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final SingletonDemo singletonDemo = new SingletonDemo();

    private SingletonDemo(){}

    public static SingletonDemo getInstance(){
        return singletonDemo;
    }

    public Object readResolve(){
        return singletonDemo;
    }
}
