package com.linyf.demo.classloader;

public class ForName {
    static {
        System.out.println("静态代码块初始化");
    }

    private static String name = method();

    private static String method(){
        System.out.println("给静态变量赋值的静态方法执行");
        return "aaa";
    }
}
