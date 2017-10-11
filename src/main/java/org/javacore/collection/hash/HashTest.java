package org.javacore.collection.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * hashCode方法用来找到该对象在哪一个“桶”，equals来判断这个“桶”里找到的类
 * 如果不重写hashCode，Object的hashCode是将对象的内部地址转换成一个整数来实现
 * equals比较的是两个对象的引用，但是有些类重写了equals方法（String、Date等），比较的是指向的值
 * 自己重写equals方法的一般步骤：1.判断是否为null，然就返回false 2.是否为同一个引用，然就返回true 3.如不是同一种类，就返回false 4.判断hashCode
 */
public class HashTest {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int hashCode() {
        return i % 10;
    }

    public static void main(String[] args) {
        HashTest a = new HashTest();
        HashTest b = new HashTest();
        a.setI(1);
        b.setI(1);
        Set<HashTest> set = new HashSet<HashTest>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }
}
