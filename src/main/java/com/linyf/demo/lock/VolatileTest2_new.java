package com.linyf.demo.lock;

public class VolatileTest2_new {
    public static int count = 0; // 计数器
    public static final int size = 100000; // 循环测试次数

    public static void main(String[] args) {
        // ++ 方式
        Thread thread = new Thread(() -> {
            synchronized (VolatileTest2_new.class){
                for (int i = 1; i <= size; i++) {
                    count++;
                }
            }
        });
        thread.start();
        // -- 方式
        synchronized (VolatileTest2_new.class){
            for (int i = 1; i <= size; i++) {
                count--;
            }
        }
        // 等所有线程执行完成
        while (thread.isAlive()) {}
        System.out.println(count); // 打印结果
    }
}
