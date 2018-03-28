/**
 * BrandBigData.com Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.javacore.thread.wait;

/**
 * @author HaoBin
 * @version $Id: WaitTest.java, v0.1 2018/3/28 18:05 HaoBin
 */
public class WaitTest extends Thread{

    private String name;
    private Object prev;
    private Object self;

    private WaitTest(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        WaitTest pa = new WaitTest("A", c, a);
        WaitTest pb = new WaitTest("B", a, b);
        WaitTest pc = new WaitTest("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}