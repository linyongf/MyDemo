package com.linyf.demo.lock;

public class VolatileTest {
    // 可见性参数
    private volatile static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                // 暂停 0.5s 执行
                Thread.sleep(500);

                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 一直循环检测 flag=true
        while (true) {
            if (flag) {
                System.out.println("检测到 flag 变为 true");
                break;
            }
        }
    }
}
