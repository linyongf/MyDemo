package com.linyf.demo;

public class JDKBugTest {
    private void test(){
        int i=8;
        while((i -= 3) >0);
        System.out.println("i:" + i);
    }

    public static void main(String[] args) {
        JDKBugTest jdkBugTest = new JDKBugTest();
        for (int i = 0; i < 9000; i++) {
            jdkBugTest.test();
        }

    }
}
