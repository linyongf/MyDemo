package com.linyf.demo.thread.create;

public class Method1 {
    public static void main(String[] args) {
        new MyThread1().start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("线程创建方式1");
    }
}
