package com.linyf.demo.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String result1 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        String result2 = now.format(DateTimeFormatter.ISO_DATE);
        String result3 = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        System.out.println("基本格式1：" + result1);
        System.out.println("基本格式2：" + result2);
        System.out.println("自定义格式：" + result3);
    }
}
