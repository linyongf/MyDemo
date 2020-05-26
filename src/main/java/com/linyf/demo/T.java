package com.linyf.demo;

import java.util.HashMap;

public class T extends HashMap implements Runnable {
    private volatile int count = 100;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "---" + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }
}
