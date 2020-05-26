package com.linyf.demo.sugar;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        String[] strings = {"zhangsan", "lisi", "wangwu"};
        for (String string : strings) {
            System.out.println(string);
        }

        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
