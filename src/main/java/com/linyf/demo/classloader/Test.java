package com.linyf.demo.classloader;

public class Test {
    public static void main(String[] args) throws Exception{
//        Class<?> aClass = Class.forName("com.linyf.demo.classloader.ForName");
        ClassLoader.getSystemClassLoader().loadClass("com.linyf.demo.classloader.ForName");
    }
}
