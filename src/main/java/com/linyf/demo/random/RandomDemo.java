package com.linyf.demo.random;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();

        /**
         * bound 必须大于0
         * public int nextInt(int bound) {
         *         if (bound <= 0)
         *             throw new IllegalArgumentException(BadBound);
         *
         *         int r = next(31);
         *         int m = bound - 1;
         *         if ((bound & m) == 0)  // i.e., bound is a power of 2
         *             r = (int)((bound * (long)r) >> 31);
         *         else {
         *             for (int u = r;
         *                  u - (r = u % bound) + m < 0;
         *                  u = next(31));
         *         }
         *         return r;
         *     }
         */
        for (int i = 0; i < 100; i++) {
            int randomWintNextIntWithinARange = random.nextInt(100 + 100) - 100;
            System.out.println(randomWintNextIntWithinARange);
        }
    }
}
