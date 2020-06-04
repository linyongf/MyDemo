package com.linyf.demo.thread.msg;

public class ThreadMsgTest {
    /**
     * 定义一个测试
     */
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        notifyThreadWithVolatile();
    }

    private static void notifyThreadWithVolatile() throws InterruptedException {
        Thread thc = new Thread("线程A"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        flag = true;
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                }
            }
        };

        Thread thd = new Thread("线程B") {
            @Override
            public void run() {
                while (true) {
                    // 防止伪唤醒 所以使用了while
                    while (flag) {
                        System.out.println(Thread.currentThread().getName() + "收到通知");
                        System.out.println("do something");
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return ;
                    }

                }
            }
        };

        thd.start();
        Thread.sleep(1000L);
        thc.start();
    }
}
