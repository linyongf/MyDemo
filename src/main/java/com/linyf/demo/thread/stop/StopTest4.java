package com.linyf.demo.thread.stop;

public class StopTest4 {
    public static void main(String[] args) {
        Thread thread = new MyThread1();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends  Thread{
    @Override
    public void run(){
        try{
            for(int i=0; i<500000; i++){
                if(this.interrupted()) {
                    System.out.println("线程已经终止， for循环不再执行");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }

            System.out.println("for循环外面的语句，也会执行");
        }catch (InterruptedException e){
            System.out.println("捕获到了线程终端异常。。。");
            e.printStackTrace();
        }
    }
}
