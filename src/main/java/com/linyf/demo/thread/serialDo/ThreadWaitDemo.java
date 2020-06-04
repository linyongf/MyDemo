package com.linyf.demo.thread.serialDo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    private static Boolean t1Run = false;
    private static Boolean t2Run = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                t1Run = true;
                System.out.println("产品经理规划新需求");
                condition1.signal();
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                if (!t1Run) {
                    System.out.println("开发人员先休息会...");
                    condition1.await();
                }

                t2Run = true;
                System.out.println("开发人员开发新需求功能");
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread thread3 = new Thread(() -> {
            lock.lock();
            try {
                if (!t2Run) {
                    System.out.println("测试人员先休息会...");
                    condition2.await();
                }
                System.out.println("测试人员测试新功能");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
