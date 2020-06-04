package com.linyf.demo.thread.serialDo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("产品经理规划新需求"));

        Thread thread2 = new Thread(() -> {
            System.out.println("开发人员开发新需求功能");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("测试人员测试");
        });

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
