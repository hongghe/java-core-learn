package org.javacore.lambda;


/**
 * Lambda - 启动线程
 *
 * Created by bysocket on 16/7/13.
 */
public class LambdaRunnable {
    static int b = 10;

    public static void main(String[] args) {
        // 启动线程
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                b++;
//                System.out.println(b);
//            }
//        });

        // Lambda - 启动线程
        // lambda无参函数
        Thread thread = new Thread(() -> {
            b++;
            System.out.println(b);
        });
        thread.start();
        System.out.println("Done!");
    }
}
