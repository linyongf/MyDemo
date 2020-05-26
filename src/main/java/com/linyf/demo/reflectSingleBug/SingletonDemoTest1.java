package com.linyf.demo.reflectSingleBug;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemoTest1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException {
        SingletonDemo instance = SingletonDemo.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:\\single.txt"));
        objectOutputStream.writeObject(instance);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\single.txt"));
        SingletonDemo instance1 = (SingletonDemo) objectInputStream.readObject();

        System.out.println(instance);
        System.out.println(instance1);
    }
}
