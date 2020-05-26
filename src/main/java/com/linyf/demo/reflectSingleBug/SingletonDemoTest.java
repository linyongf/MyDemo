package com.linyf.demo.reflectSingleBug;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemoTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        Class<SingletonDemo> singletonDemo = (Class<SingletonDemo>)Class.forName("com.linyf.demo.reflectSingleBug.SingletonDemo");
        Constructor<SingletonDemo> declaredConstructor = singletonDemo.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        SingletonDemo instance3 = declaredConstructor.newInstance();

        Class<SingletonDemo> singletonDemo1 = (Class<SingletonDemo>)Class.forName("com.linyf.demo.reflectSingleBug.SingletonDemo");
        Constructor<SingletonDemo> declaredConstructor1 = singletonDemo1.getDeclaredConstructor(null);
        declaredConstructor1.setAccessible(true);
        SingletonDemo instance4 = declaredConstructor1.newInstance();

        System.out.println(instance3);
        System.out.println(instance4);

    }
}
