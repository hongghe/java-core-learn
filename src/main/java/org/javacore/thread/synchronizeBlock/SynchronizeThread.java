package org.javacore.thread.synchronizeBlock;

/**
 * @Author: HaoBin
 * @Date 2017/11/20 15:15
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 */

class CountT {
    public void synMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public void noSynMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}

public class SynchronizeThread {
    public static void main(String[] args) {
        final CountT count = new CountT();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.noSynMethod();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
