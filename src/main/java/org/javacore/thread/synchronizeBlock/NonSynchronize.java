package org.javacore.thread.synchronizeBlock;

/**
 * @Author: HaoBin
 * @Date 2017/11/20 15:06
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
 */

class Count {
    public void synMethod() {
        synchronized (this) {
            try {
                for(int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public void noSynMethod() {
        try {
            for(int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
            }
        } catch (InterruptedException e) {

        }
    }
}
public class NonSynchronize {
    public static void main(String[] args) {
        final Count count = new Count();

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
