package com.linyf.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象的五种方式
 */
public class ObjectCreateTest implements Cloneable{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {
        // 1. 使用new 关键字创建
        Object o = new Object();

        // 2. 使用反射
        Object o1 = Object.class.newInstance();

        // 3. 使用Constructor
        Constructor<Object> constructor = Object.class.getConstructor();
        Object o2 = constructor.newInstance();

        // 4. clone 需要实现实现Cloneable接口 ----------不常用
        ObjectCreateTest objectCreateTest = new ObjectCreateTest();
        ObjectCreateTest clone = (ObjectCreateTest)objectCreateTest.clone();

        // 5. 反序列化 ------------不常用
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        ObjectCreateTest seriaObj = (ObjectCreateTest) in.readObject();
    }
}
