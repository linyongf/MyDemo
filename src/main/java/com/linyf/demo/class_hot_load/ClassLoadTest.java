package com.linyf.demo.class_hot_load;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClassLoadTest {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ManagerFactory.getManager(ManagerFactory.MY_MANAGER).logic();
            }
        },1, 5, TimeUnit.SECONDS);
    }
}
