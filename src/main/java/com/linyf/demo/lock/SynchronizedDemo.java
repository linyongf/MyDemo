package com.linyf.demo.lock;

class SynchronizedDemo {

    public synchronized void method1() {
        method2();
    }

    public synchronized void method2() {

    }


}

public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
