package org.javacore.thread.sleep;

/**
 * @Author: HaoBin
 * @Date 2017/11/21 11:39
 * sleep和wait的比较
 */
public class SleepAndWait {
    private static Object obj = new Object();

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.printf("%s: %d\n", this.getName(), i);
                        // 能被4整除就休眠2秒
                        if (i % 4 == 0) {
                            Thread.sleep(2000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        // sleep是不会释放对象的锁
        t1.start();
        t2.start();
    }
}
