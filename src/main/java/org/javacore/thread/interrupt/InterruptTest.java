package org.javacore.thread.interrupt;

/**
 * @Author: HaoBin
 * @Date 2017/11/23 10:37
 * interrupt终止线程
 */

class MyThread extends Thread {
    public MyThread (String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
        }
    }
}

public class InterruptTest {
    public static void main(String[] args) {
        try {
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");
            // 启动t1
            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is start.");

            // 主线程休眠300ms然后给t1发出中断指令
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

            // 主线程休眠300ms，然后查看t1状态
            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
