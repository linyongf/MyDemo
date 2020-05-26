package com.linyf.demo.random;

public class MathDemo {
    public static void main(String[] args) {
//        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            System.out.println(random);
        }

        for (int i = 0; i < 100; i++) {
            int randomWithMathRandom = (int) ((Math.random() * (100 + 100)) -100);
            System.out.println(randomWithMathRandom);
        }
    }
}
