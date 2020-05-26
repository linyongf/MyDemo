package com.linyf.demo.date;

import java.time.LocalDateTime;

public class LocalDateTime1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        System.out.println("当前年份：" + now.getYear());
        System.out.println("当前月份：" + now.getMonthValue());
        System.out.println("当前日份：" + now.getDayOfMonth());
        System.out.println("当前周几：" + now.getDayOfWeek().getValue());

        System.out.println("当前时：" + now.getHour());
        System.out.println("当前分：" + now.getMinute());
        System.out.println("当前秒：" + now.getSecond());
    }
}
