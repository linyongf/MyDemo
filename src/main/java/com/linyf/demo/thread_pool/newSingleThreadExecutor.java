package com.linyf.demo.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newSingleThreadExecutor {
    public static void method() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "   " + index);
            });
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        method();
    }
}
