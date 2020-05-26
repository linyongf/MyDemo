package com.linyf.demo.random;

import java.util.SplittableRandom;

public class SplittableRandomDemo {
    public static void main(String[] args) {
        SplittableRandom random = new SplittableRandom();

        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(1, 10);
            System.out.println(i1);
        }
    }
}
