package com.linyf.demo.random;
import java.util.concurrent.ThreadLocalRandom;
public class ThreadLocalRandomDemo1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt(1,10);
            System.out.println(randomWithThreadLocalRandom);
        }
    }
}
