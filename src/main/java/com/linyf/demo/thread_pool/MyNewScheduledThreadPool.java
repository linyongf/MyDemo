package com.linyf.demo.thread_pool;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyNewScheduledThreadPool {
    /**
     * scheduleWithFixedDelay
     *
     * 如果间隔时间大于任务的执行时间，任务不受执行时间的影响。如果间隔时间小于任务的执行时间，
     * 那么任务执行结束之后，会立马执行，至此间隔时间就会被打乱。
     */
    public static void method1() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        executor.scheduleAtFixedRate(() -> {
            long start = new Date().getTime();
            System.out.println("scheduleAtFixedRate 开始执行时间:" + LocalTime.now());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = new Date().getTime();
            System.out.println("scheduleAtFixedRate 执行花费时间=" + (end - start) / 1000 + "m");
            System.out.println("scheduleAtFixedRate 执行完成时间：" + LocalTime.now());
            System.out.println("======================================");
        }, 1, 5, TimeUnit.SECONDS);
    }

    /**
     *总结：scheduleWithFixedDelay的间隔时间不会受任务执行时间长短的影响
     */
    public static void method2() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m");
                System.out.println("scheduleWithFixedDelay执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
         method2();
    }
}
