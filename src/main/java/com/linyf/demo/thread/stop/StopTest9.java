package com.linyf.demo.thread.stop;

public class StopTest9 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        Thread thread = new MyThread6(synchronizedObject);
        thread.start();
        Thread.sleep(500);
        thread.stop();
        System.out.println(synchronizedObject.getName() + " " + synchronizedObject.getPassword());
    }
}

class MyThread6 extends Thread {
    private SynchronizedObject synchronizedObject;
    public MyThread6(SynchronizedObject synchronizedObject){
        this.synchronizedObject = synchronizedObject;
    }

    public void run(){
        synchronizedObject.printString("b", "bb");
    }
}

class SynchronizedObject {
    private String name = "a";
    private String password = "aa";

    public synchronized void printString(String name, String password){
        try {
            this.name = name;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
