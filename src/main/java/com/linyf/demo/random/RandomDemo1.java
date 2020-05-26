package com.linyf.demo.random;

import java.util.Random;

public class RandomDemo1 {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomWithNextInt = random.nextInt();
            System.out.println(randomWithNextInt);
        }
    }
}
