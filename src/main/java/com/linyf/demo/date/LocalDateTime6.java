package com.linyf.demo.date;

import java.time.LocalDateTime;

public class LocalDateTime6 {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.of(2019, 4, 1, 12, 0);
        LocalDateTime time2 = LocalDateTime.of(2020, 4, 1, 12, 0);
        System.out.println("time1 在 time2 之前：" + time1.isBefore(time2));
    }
}
