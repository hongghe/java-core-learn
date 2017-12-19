package org.javacore.base.referrence;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HaoBin
 * @Date 2017/12/14 14:55
 */
public class CollectionT {

    public static void printArrayList(List<A> list) {
        for (A item : list) {
            System.out.println(item.name);
        }
    }

    public static void test1() {
        // 创建一个对象A，引用a指向A
        A a = new A("zhangsan");
        List<A> list = new ArrayList<>();
        // 把对象A的引用放入List，对象A本身没有放进List
        list.add(a);
        printArrayList(list);
        A b = new A("haobin");
        // a指向了一个新的对象
        a = b;
        // 这个时候list有两个元素了
        list.add(a);
        printArrayList(list);
    }

    public static void main(String[] args) {

    }
}
