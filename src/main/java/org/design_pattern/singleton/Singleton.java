package org.design_pattern.singleton;

/**
 * 最简单的单例模式，线程不安全
 * @Author: HaoBin
 * @Date 2018/1/31 17:38
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getSingleton() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
