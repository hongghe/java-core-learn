package org.javacore.thread.wake;

/**
 * @Author: HaoBin
 * @Date 2017/11/20 16:48
 * wait和notify的使用
 */
class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    public void run() {
       synchronized (this) {
           System.out.println(Thread.currentThread().getName() + " call notify()");
           // 唤醒当前wait的线程
           notify();
       }
    }
}
public class WaitAndNotify {
    public static void main(String[] args) {

        ThreadA t1= new ThreadA("t1");

        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                System.out.println(Thread.currentThread().getName() + " wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {

            }
        }
    }
}
