package com.linyf.demo.thread.serialDo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier(回环栅栏)实现线程按顺序运行
 */
public class CyclicBarrierDemo {
    /**
     * 用于判断线程1是否执行，倒计时设置为1，执行后减1
     */
    private static CyclicBarrier c1 = new CyclicBarrier(2);
    /**
     * 用于判断线程2是否执行，倒计时设置为1，执行后减1
     */
    private static CyclicBarrier c2 = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("产品经理规划新需求");

            try {
                // 放开栅栏1
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        );

        Thread thread2 = new Thread(() -> {
            try {
                //放开栅栏1
                c1.await();
                System.out.println("开发人员开发新需求功能");
                //放开栅栏2
                c2.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        });

        Thread thread3 = new Thread(() -> {
            try {
                //放开栅栏2
                c2.await();
                System.out.println("测试人员测试");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
