package com.linyf.demo.thread.serialDo;

public class MainThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println("产品经理规划新需求"));

        Thread thread2 = new Thread(() -> {
            System.out.println("开发人员开发新需求功能");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("测试人员测试");
        });

        thread1.start();

        thread1.join();
        thread2.start();

        thread2.join();
        thread3.start();

    }
}
