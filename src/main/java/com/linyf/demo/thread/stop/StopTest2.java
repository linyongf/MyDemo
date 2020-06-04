package com.linyf.demo.thread.stop;

public class StopTest2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("stop 1 interrupt:" + Thread.currentThread().interrupted());
        System.out.println("stop 2 interrupt:" + Thread.currentThread().interrupted());
    }
}
