package org.javacore.thread.sleep;

/**
 * @Author: HaoBin
 * @Date 2017/11/21 11:32
 * sleep的简单实用
 */
class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    public synchronized void run () {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", this.getName(), i);
                // 能被4整除就休眠2秒
                if(i % 4 == 0) {
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SimpleSleep {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
    }
}
