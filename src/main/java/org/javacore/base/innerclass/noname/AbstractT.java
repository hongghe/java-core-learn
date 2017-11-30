package org.javacore.base.innerclass.noname;

/**
 * 使用匿名内部类来实现抽象方法
 * @Author: HaoBin
 * @Date 2017/11/29 23:51
 */
public class AbstractT {
    public static void main(String[] args) {
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("eat");
            }
        };
        p.eat();
    }
}

abstract class Person {
    public abstract void eat();
}


