package com.linyf.demo;

public class EscapeAnalysisTest {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            allocate();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
        Thread.sleep(600000);
    }

    static void allocate() {
        MyObject myObject = new MyObject(2019, 2019.0);
    }

    static class MyObject {
        int a;
        double b;

        MyObject(int a, double b) {
            this.a = a;
            this.b = b;
        }
    }
}
