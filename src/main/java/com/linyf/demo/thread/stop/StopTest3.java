package com.linyf.demo.thread.stop;

public class StopTest3 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();
        System.out.println("stop 1 interrupt:" + thread.isInterrupted());
        System.out.println("stop 2 interrupt:" + thread.isInterrupted());
    }
}
