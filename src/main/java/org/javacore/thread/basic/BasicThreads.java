package org.javacore.thread.basic;



/**
 * 传统多线程的调用是 Thread -> start
 * Thread构造函数有个Runnable target,target是一个继承了Runnable接口重写了run方法的类
 * Thread类中调用顺序 start->start0->run->target.run
 */

// 简单的多线程使用
public class BasicThreads {
    public static void main(String[] args) {
        // 创建新的线程
        Thread t = new Thread(new LiftOff());
        // 执行线程
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
