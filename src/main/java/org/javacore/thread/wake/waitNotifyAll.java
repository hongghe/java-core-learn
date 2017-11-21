package org.javacore.thread.wake;

/**
 * @Author: HaoBin
 * @Date 2017/11/21 11:22
 */
public class waitNotifyAll {
    private static Object obj = new Object();

    class ThreadC extends Thread {
        public ThreadC(String name) {
            super(name);
        }

        public void run() {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait ");
                    // 唤醒当前wait的线程
                    obj.wait();

                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
