package com.linyf.demo.sugar;

public class SwitchDemo {
    public static void main(String[] args) {
        String str = "zhangsan";
        switch (str) {
            case "zhangsan":
                System.out.println("zhangsan");
                break;
            case "lisi":
                System.out.println("lisi");
                break;
            default:
                break;
        }
    }
}
