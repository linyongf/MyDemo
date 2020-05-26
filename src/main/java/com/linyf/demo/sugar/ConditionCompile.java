package com.linyf.demo.sugar;

public class ConditionCompile {
    public static void main(String[] args) {
        final boolean aaa= true;
        if(aaa) {
            System.out.println("aaa!");
        }

        final boolean bbb= false;
        if(bbb){
            System.out.println("bbb!");
        }
    }
}
