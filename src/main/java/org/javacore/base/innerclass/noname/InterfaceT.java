package org.javacore.base.innerclass.noname;

/**
 * 匿名内部类来实现接口
 * @Author: HaoBin
 * @Date 2017/11/29 23:52
 */
public class InterfaceT {
    public static void main(String[] args) {
        Person1 person1 = new Person1() {
            @Override
            public void eat() {
                System.out.println("eat interface");
            }
        };
        person1.eat();

    }
}
interface Person1 {
    public void eat();
}
