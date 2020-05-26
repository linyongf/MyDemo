package com.linyf.demo.string;

public class StringDemo2 {
    public static void main(String[] args) {
        String st1 = new String("abc");
        String st2 = "abc";
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
    }
}
