package com.linyf.demo.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTime3 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        now = now.plusDays(1);// 加1天
        now = now.minusHours(1);// 减一小时
        now = now.plus(1, ChronoUnit.WEEKS); //加一周

        now = now.withMinute(59); // 直接设置分钟为59
        System.out.println("修改后时间：" + now);
    }
}
