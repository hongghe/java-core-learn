package org.javacore.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 操作符
 *
 * Created by bysocket on 16/7/13.
 */
public class LambdaOperators {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("cccc");
        list.add("b");
        list.add("eeeee");

        /**
         * :: 操作符格式 => 三种情况
         *    对象::实例方法
         *    类::静态方法
         *    类::实例方法 对于前两种情况，方法引用就是对参数执行该方法。比如下面两种方法
         */
        // 按字符串大小排序忽略大小写
        list.sort(String::compareToIgnoreCase);
        // 打印 list 元素,双冒号操作等于如下，相当于省略了参数
//        list.forEach((itme) -> {
//            System.out.println(itme);
//        });
        list.forEach(System.out::println);

        System.out.println("======按字符大小排序======");
        list.sort(Comparator.comparing(String::length));
        list.forEach(System.out::println);
    }
}
