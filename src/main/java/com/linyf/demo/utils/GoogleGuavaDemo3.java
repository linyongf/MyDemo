package com.linyf.demo.utils;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleGuavaDemo3 {
    public static void main(String[] args) {
        Stopwatch started = Stopwatch.createStarted();

        List<String> list = Lists.newArrayListWithExpectedSize(10_000_000);
        for (int i = 0; i < 10_000_000; i++) {
            list.add("zhangsan" );
        }

        for (String s : list) {
            System.out.println(s);

        }
        System.out.println(started.elapsed(TimeUnit.SECONDS));
    }
}
