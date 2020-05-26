package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkipDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        List<Integer> collect = list.stream().skip(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
