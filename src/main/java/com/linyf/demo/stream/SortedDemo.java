package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(2);
            add(5);
            add(4);
        }};
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
