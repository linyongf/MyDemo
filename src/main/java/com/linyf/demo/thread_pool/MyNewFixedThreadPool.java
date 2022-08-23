package com.linyf.demo.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优点：两个结果综合说明，newFixedThreadPool的线程数是可以进行控制的，因此我们可以通过控制最大线程数来使我们的服务器达到最大的使用率，
 *      同时又可以保证即使流量突然增大也不会占用服务器过多的资源。
 */
public class MyNewFixedThreadPool {
    public static void method() throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(1);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + index);
            });
        }
        executor.shutdown();
    }

    public static void main(String[] args) throws Exception{
         method();
    }
}
