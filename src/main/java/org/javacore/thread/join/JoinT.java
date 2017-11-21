package org.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * @Author: HaoBin
 * @Date 2017/11/21 11:55
 * join:让主线程等待子线程结束后在继续运行
 */
class NetLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the NetLoader");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NetLoader has finished");
    }
}

class DSLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the DSLoader");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DSLoader has finished");
    }
}

public class JoinT {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new DSLoader());
        Thread t2 = new Thread(new NetLoader());

        t1.start();
        t2.start();

        //可以注释其中一个加深理解
        t1.join();
        //t2.join();

        System.out.println("ending all");
    }
}
