package com.linyf.demo.thread.stop;

public class StopTest7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread4();
        thread.start();
        Thread.sleep(2000);
        thread.stop();
    }
}

class MyThread4 extends Thread {
    private static int i = 0;
    @Override
    public void run() {
           while (true) {
               i++;
               System.out.println(i);
           }
    }
}
