package com.linyf.demo.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 不足：这种方式虽然可以根据业务场景自动的扩展线程数来处理我们的业务，但是最多需要多少个线程同时处理却是我们无法控制的；
 *
 * 优点：如果当第二个任务开始，第一个任务已经执行结束，那么第二个任务会复用第一个任务创建的线程，并不会重新创建新的线程，提高了线程的复用率
 */
public class MyNewCachedThreadPool {
    public static void method() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int index = i;
//            Thread.sleep(1000);
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + "  " + index));
        }
    }

    public static void main(String[] args) throws Exception{
         method();
    }
}
