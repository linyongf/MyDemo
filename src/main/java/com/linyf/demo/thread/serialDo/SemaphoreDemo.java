package com.linyf.demo.thread.serialDo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 使用Sephmore(信号量)实现线程按顺序运行
 */
public class SemaphoreDemo {
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("产品经理规划新需求");
           s1.release();
        }
        );

        Thread thread2 = new Thread(() -> {
            try {
                s1.acquire();
                System.out.println("开发人员开发新需求功能");
                s2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                s2.acquire();
                System.out.println("测试人员测试");
                s2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
