package com.linyf.demo.lock;

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

    public void method(){
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        new Thread(()->singleton.method()).start();

        new Thread(()->singleton.method()).start();
    }
}
