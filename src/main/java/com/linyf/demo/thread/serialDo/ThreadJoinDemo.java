package com.linyf.demo.thread.serialDo;

public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("产品经理规划新需求"));

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("开发人员开发新需求功能");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                System.out.println("测试人员测试");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();

    }
}
