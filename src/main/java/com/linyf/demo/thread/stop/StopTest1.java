package com.linyf.demo.thread.stop;

public class StopTest1 {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        new Thread(() -> thread.run()).start();
        try{
            Thread.sleep(2000);
            thread.interrupt();

            System.out.println("stop 1 interrupt:" + thread.interrupted());
            System.out.println("stop 2 interrupt:" + thread.interrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<500000; i++){
            i++;
            System.out.println(i);
        }
    }
}
