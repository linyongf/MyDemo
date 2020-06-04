package com.linyf.demo.thread.serialDo;

import java.util.concurrent.CountDownLatch;

/**
 * 通过CountDownLatch（倒计时）使线程按顺序执行
 */
public class ThreadCountDownLatchDemo {
    /**
     * 用于判断线程1是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c1 = new CountDownLatch(1);
    /**
     * 用于判断线程2是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("产品经理规划新需求");

            // 对c1 倒计时 -1
            c1.countDown();
        }
        );

        Thread thread2 = new Thread(() -> {
            try {
                //等待c1倒计时，计时为0则往下运行
                c1.await();
                System.out.println("开发人员开发新需求功能");
                // 对c2 倒计时 -1
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread3 = new Thread(() -> {
            try {
                //等待c1倒计时，计时为0则往下运行
                c2.await();
                System.out.println("测试人员测试");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
