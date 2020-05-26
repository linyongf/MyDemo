package com.linyf.demo.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(0.05 + 0.12);

        BigDecimal bigDecimal = new BigDecimal("0.05");
        BigDecimal bigDecima2 = new BigDecimal("0.12");

        System.out.println(bigDecimal.add(bigDecima2));
    }
}
