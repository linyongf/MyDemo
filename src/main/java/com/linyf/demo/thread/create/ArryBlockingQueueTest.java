package com.linyf.demo.thread.create;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArryBlockingQueueTest {
    private static final int maxSize = 5;

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(maxSize);
        new Thread(new Productor(queue)).start();
        new Thread(new Customer(queue)).start();
    }
}

class Customer implements Runnable {
    private BlockingQueue queue;

    public Customer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        cusume();
    }

    private void cusume(){
        while (true) {
            try{
                int count = (int)queue.take();
                System.out.println("customer 正在消费第" + count + "个商品。。。");

                // 只是为了方便观察输出结果
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Productor implements Runnable {
    private BlockingQueue queue;

    private int count = 1;

    public Productor(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        product();
    }

    private void product(){
        while (true) {
            try{
                queue.put(count++);
                System.out.println("customer 正在生成第" + count + "个商品。。。");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


