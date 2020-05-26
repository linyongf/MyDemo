package com.linyf.demo.sugar;

public class BoxDemo {
//    public static void main(String[] args) {
//        int a = 10;
//        Integer b = a;
//
//        Integer c = 10;
//        int d = c;
//    }

    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        Integer c = 100;
        Integer d = 100;
        System.out.println("a == b is " + (a == b));
        System.out.println(("c == d is " + (c == d)));
    }
}
