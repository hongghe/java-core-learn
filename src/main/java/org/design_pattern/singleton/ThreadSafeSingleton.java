package org.design_pattern.singleton;

/**
 * 线程安全版本，但是只有第一次创建的时候才需要检测，以后getInstance的时候效率就很低
 * @Author: HaoBin
 * @Date 2018/1/31 18:26
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
