package com.linyf.demo.random;

import java.security.SecureRandom;

public class SecureRandomDemo {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        int randomWithSecureRandom = secureRandom.nextInt();
        System.out.println(randomWithSecureRandom);

        for (int i = 0; i < 10; i++) {
            int i1 = secureRandom.nextInt(10 - 1) + 1;
            System.out.println(i1);
        }
    }
}
