package com.linyf.demo.bug;

public class BugDemo1 {
    public static void main(String[] args) {
        Integer a = true ? null : 0;
        System.out.println(a);
    }
}
