package com.linyf.demo.condition_anno;

public class Rice implements Food {
    @Override
    public void showName() {
        System.out.println("吃米饭");
    }
}
