package org.javacore.thread.synchronizeBlock;


/**
 * @Author: HaoBin
 * @Date 2017/11/20 14:16
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                   Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}

class OtherThread extends Thread {

    public OtherThread(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            }catch (InterruptedException e) {

            }

        }
    }
}
public class SynchronizeBlock {
    public static void main(String[] args) {
        Runnable demo = new MyRunnable();
        // 两个线程访问不同对象的synchronize代码块不会阻塞
        Thread t1 = new OtherThread("t1");
        Thread t2 = new OtherThread("t2");
        t1.start();
        t2.start();
    }
}
