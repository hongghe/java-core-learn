package org.javacore.innerclass;

/**
 * 匿名内部类的语法：
 * 一个匿名类由以下几个部分组成：
 * 1.new操作符
 * 2.Runnable：接口名称。这里还可以填写抽象类、普通类的名称。
 * 3.()：这个括号表示构造函数的参数列表。由于Runnable是一个接口，没有构造函数，所以这里填一个空的括号表示没有参数。
 * 4.{...}：大括号中间的代码表示这个类内部的一些结构。在这里可以定义变量名称、方法。跟普通的类一样。
 *
 */

abstract class Person {
    public abstract void eat();
}


class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }
}


public class Anonymous {
    public static void main(String[] args) {
        // 普通的实现抽象类的方法
        Person p = new Child();
        p.eat();

        // 匿名内部类来实现抽象方法
        Person p1 = new Person() {
            @Override
            public void eat() {
                System.out.println("eat......");
            }
        };
        p1.eat();
    }
}
