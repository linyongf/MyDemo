package com.linyf.demo.thread.stop;

public class StopTest5 {
    public static void main(String[] args) {
        Thread thread = new MyThread2();
        thread.start();

        thread.interrupt();
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("线程开始。。。");
            Thread.sleep(200000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.interrupted());
            e.printStackTrace();
        }
    }
}
