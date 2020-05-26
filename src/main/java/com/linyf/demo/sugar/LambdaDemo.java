package com.linyf.demo.sugar;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String... args) {
        List<String> strList = Arrays.asList("zhangsan", "lisi");

        strList.forEach( s -> { System.out.println(s); } );
    }

    public static void method(List<String> list) {
        System.out.println("List<String> list");
    }

//    public static void method(List<Integer> list) {
//        System.out.println("List<Integer> list");
//    }

}
