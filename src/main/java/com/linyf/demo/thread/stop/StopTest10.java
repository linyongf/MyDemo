package com.linyf.demo.thread.stop;

public class StopTest10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread7();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}

class MyThread7 extends Thread {
    @Override
    public void run(){
        int i = 0;
        while (true){
            i++;

            if(this.interrupted()){
                System.out.println("线程被停止了。i="+i);
                return;
            }
            System.out.println("aaaa");
        }
    }
}
