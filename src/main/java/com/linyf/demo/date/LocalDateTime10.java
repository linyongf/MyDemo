package com.linyf.demo.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LocalDateTime10 {
    public static void main(String[] args) {
        TemporalAdjuster firstDayOfMonth = TemporalAdjusters.firstDayOfMonth();
        TemporalAdjuster lastDayOfMonth = TemporalAdjusters.lastDayOfMonth();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate = now.with(firstDayOfMonth);
        System.out.println("本月第一天：" + startDate);
        LocalDateTime endDate = now.with(lastDayOfMonth);
        System.out.println("本月最后一天：" + endDate);

        long numOfDaysBetween = Duration.between(startDate, endDate).toDays();
        System.out.println("相隔天数：" + numOfDaysBetween);

        List<LocalDateTime> collect = IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
        collect.add(endDate);
        collect.forEach(i -> System.out.println(i));
    }
}
