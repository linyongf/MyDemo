package com.linyf.demo.date;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTime8 {
    public static void main(String[] args) {
        TemporalAdjuster firstDayOfMonth = TemporalAdjusters.firstDayOfMonth();
        TemporalAdjuster firstDayOfNextMonth = TemporalAdjusters.firstDayOfNextMonth();
        TemporalAdjuster lastDayOfMonth = TemporalAdjusters.lastDayOfMonth();

        LocalDateTime now = LocalDateTime.now();
        now = now.with(firstDayOfMonth);
        System.out.println("本月第一天：" + now);
        now = now.with(lastDayOfMonth);
        System.out.println("本月最后一天：" + now);
        now = now.with(firstDayOfNextMonth);
        System.out.println("下月第一天：" + now);
    }
}
