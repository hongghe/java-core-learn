package org.javacore.thread.basic;

/**
 * Thread中start和run的区别
 * start方法才可以启动线程，run方法只是一个普通类的方法，仍然是由主线程来启动
 */
public class RunAndStartThread {
    public static void main(String[] args) {
        //主线程id
        System.out.println("当前线程ID => " + Thread.currentThread().getId());

        SRThread t1 = new SRThread("t1");
        //t1线程id
        t1.start();
        SRThread t2 = new SRThread("t2");
        // 可以看到调用run方法的线程id还是主线程id
        t2.run();
    }
}
class SRThread extends Thread {
    private String name;

    public SRThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name +", 线程ID => " + Thread.currentThread().getId());
    }
}
