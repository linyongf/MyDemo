package com.linyf.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private final ReentrantLock lock = new ReentrantLock();

    public void method(){
        lock.lock();
        lock.lock();

        try{
            //
        }catch(Exception e){
            //
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
}
