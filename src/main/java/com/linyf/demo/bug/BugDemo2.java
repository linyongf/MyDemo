package com.linyf.demo.bug;

public class BugDemo2 {
    int i = 1;

    private void method(){
        i = 2;
        String i = "";
    }
}
