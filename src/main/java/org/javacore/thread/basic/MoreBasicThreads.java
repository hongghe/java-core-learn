package org.javacore.thread.basic;



/**
 * @author Jeff Lee
 * @since 2015-11-2 17:09:33
 * 	线程简单使用-启动多个LiftOff线程{@link LiftOff}
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        // 五个线程同时执行
        for (int i = 0; i < 5 ; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
