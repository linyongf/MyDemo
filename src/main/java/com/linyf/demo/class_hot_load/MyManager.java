package com.linyf.demo.class_hot_load;

import java.time.LocalTime;

/**
 * BaseManager 这个接口的子类要实现类的热加载功能。
 */
public class MyManager implements BaseManager {

    @Override
    public void logic() {
        System.out.println(LocalTime.now() + ": Java类的热加载222");
    }
}
