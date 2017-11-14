package org.javacore.base.load;

/**
 * 类加载
 * @Author: HaoBin
 * @Date 2017/11/14 9:57
 */
public class ClassLoader {
    public static void main(String[] args) {
        System.out.println(System.class.getClassLoader());
        System.out.println(ClassLoader.class.getClassLoader());
    }
}
