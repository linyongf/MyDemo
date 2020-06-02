package com.linyf.demo.thread.create;

public class Method2 {
    public static void main(String[] args) {
        new Thread(new MyThread2()).start();
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("创建线程方式2");
    }
}
