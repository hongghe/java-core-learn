package org.jvm;

/**
 * @Author: HaoBin
 * @Date 2018/2/25 13:56
 */
public class GC {
    public static void main(String[] args) {
        Object obj = new byte[1024 * 1024 * 1];
        obj = null;
        System.gc();
    }
}
