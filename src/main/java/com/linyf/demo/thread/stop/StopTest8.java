package com.linyf.demo.thread.stop;

public class StopTest8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread5();
        thread.start();
    }
}

class MyThread5 extends Thread {
    private static int i = 0;
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("调用stop方法, 进入异常catch");
            e.printStackTrace();
        }
    }
}
