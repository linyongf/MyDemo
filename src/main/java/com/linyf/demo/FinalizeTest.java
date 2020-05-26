package com.linyf.demo;

public class FinalizeTest {
    private static FinalizeTest finalizeTest = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法执行了");
        FinalizeTest.finalizeTest = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeTest = new FinalizeTest();
        finalizeTest = null;
        System.gc();
        Thread.sleep(1000);
        if(finalizeTest!=null){
            System.out.println("对象被拯救了");
        }else{
            System.out.println("对象死亡了");
        }

        finalizeTest = null;
        System.gc();
        Thread.sleep(1000);
        if(finalizeTest!=null){
            System.out.println("对象被拯救了");
        }else{
            System.out.println("对象死亡了");
        }
    }
}
