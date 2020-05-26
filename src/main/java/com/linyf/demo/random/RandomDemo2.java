package com.linyf.demo.random;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomDemo2 {
    public static void main(String[] args) {
        Random random = new Random();
        // 不带参数的 ints方法将返回一个无限 int 流：
        IntStream intStream = random.ints();
        OptionalInt first = intStream.findFirst();
        System.out.println(first.getAsInt());

//        调用时还可以指定参数来限制流大小：
//        IntStream limitedIntStream = random.ints(streamSize);

//        为生成数值设置最大值和最小值
        IntStream ints = random.ints(10, 10, 15);
        int[] ints1 = ints.toArray();
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
