package com.linyf.demo.thread.stop;

public class StopTest6 {
    public static void main(String[] args) {
        Thread thread = new MyThread3();
        thread.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("线程开始。。。");
            this.interrupt();
            Thread.sleep(2000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到sleep，进入catch异常");
            e.printStackTrace();
        }
    }
}
