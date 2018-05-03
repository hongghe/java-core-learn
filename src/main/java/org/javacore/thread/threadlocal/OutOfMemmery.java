/**
 * BrandBigData.com Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.javacore.thread.threadlocal;

/**
 * @author HaoBin
 * @version $Id: OutOfMemmery.java, v0.1 2018/5/3 16:07 HaoBin
 */
public class OutOfMemmery {
    private static A a = new A();
    private static final ThreadLocal<A> threadlocal = new ThreadLocal<A>(){
        @Override
        protected A initialValue() {
            return a;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadlocal.get().setNumber(threadlocal.get().getNumber() + 5);
                    System.out.println(Thread.currentThread().getName() + ":" + threadlocal.get().getNumber());
                }
            }, "Thread-" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class A {
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}