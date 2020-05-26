package com.linyf.demo.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("加", "油", "!");
        String reduce = list.stream().reduce("武汉", (i, j) -> i.concat(j));
        System.out.println(reduce);
    }
}
