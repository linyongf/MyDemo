package com.linyf.demo.Throwable;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        try{
            method();
            int i = 0;
            System.out.println("try执行了");
            return;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("catch执行了");
            return;
        }finally {
            System.out.println("finally");
        }
    }

    private static String method() throws ArithmeticException{
        int i = 1/0;
        return "aaa";
    }
}
