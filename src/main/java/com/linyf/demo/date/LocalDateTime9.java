package com.linyf.demo.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTime9 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        now = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        System.out.println(now);
        now = LocalDateTime.now();
        now = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(now);
    }
}
