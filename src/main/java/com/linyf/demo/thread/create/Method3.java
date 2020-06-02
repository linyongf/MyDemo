package com.linyf.demo.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Method3 {
    public static void main(String[] args) throws Exception{
        FutureTask futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();

        // get方法会阻塞调用的线程
        Integer sum = (Integer) futureTask.get();
        System.out.println(Thread.currentThread().getId() + "---" +Thread.currentThread().getName() + "---" + sum);
    }
}

class MyCallable implements Callable{
    @Override
    public Integer call(){
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getId() + "---" +Thread.currentThread().getName());
        return sum;
    }
}
