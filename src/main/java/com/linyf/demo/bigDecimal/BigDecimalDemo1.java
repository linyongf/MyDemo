package com.linyf.demo.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalDemo1 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.05);
        BigDecimal b = new BigDecimal(0.12);
        System.out.println(a.add(b));

        BigDecimal c = new BigDecimal("0.05");
        BigDecimal d = new BigDecimal("0.12");
        System.out.println(c.add(d));
    }
}
