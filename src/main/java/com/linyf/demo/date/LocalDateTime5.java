package com.linyf.demo.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime5 {
    public static void main(String[] args) {
        LocalDateTime parse = LocalDateTime.parse("2020-02-01", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
    }
}
