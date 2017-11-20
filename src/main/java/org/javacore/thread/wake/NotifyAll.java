package org.javacore.thread.wake;

/**
 * @Author: HaoBin
 * @Date 2017/11/20 18:21
 * wait和notifyAll配合使用
 */
class ThreadB extends Thread {
    public ThreadB(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " run");
            // 死循环, 不断运行
            while(true)
                ;
        }
    }
}
public class NotifyAll {
    public static void main(String[] args) {
        ThreadB t1 = new ThreadB("t1");

        synchronized (t1) {
            try {
                // 启动线程t1
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                // 主线程等待t1的唤醒，或延时超过3000ms自然唤醒
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
