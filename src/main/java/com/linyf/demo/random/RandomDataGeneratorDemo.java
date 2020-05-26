package com.linyf.demo.random;

import org.apache.commons.math3.random.RandomDataGenerator;

public class RandomDataGeneratorDemo {
    public static void main(String[] args) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        for (int i = 0; i < 10; i++) {
            int randomWithRandomDataGenerator = randomDataGenerator.nextInt(1, 10);
            System.out.println(randomWithRandomDataGenerator);
        }
    }
}
