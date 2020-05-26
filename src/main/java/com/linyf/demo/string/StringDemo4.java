package com.linyf.demo.string;

public class StringDemo4 {
    public static void main(String[] args) {
        String st1 = "ab";
        String st2 = "abc";
        String st3 = st1 + "c";
        System.out.println(st2 == st3);
        System.out.println(st2.equals(st3));
    }
}
