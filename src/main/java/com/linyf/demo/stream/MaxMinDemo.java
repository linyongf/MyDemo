package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;

public class MaxMinDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
            add(5);
            add(4);
            add(1);
            add(0);
        }};

        Integer max = list.stream().max((i, j) -> Integer.compare(i, j)).get();
        System.out.println(max);

        Integer min = list.stream().min((i, j) -> Integer.compare(i, j)).get();
        System.out.println(min);
    }
}
