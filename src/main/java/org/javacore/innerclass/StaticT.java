package org.javacore.innerclass;

/**
 * 内部静态类
 * 内部类需要依赖于外部类的对象来实例实例化
 * 而内部静态类直接依附在外部类上
 */
public class StaticT {

    public static void main(String[] args) {
        OutClass out = new OutClass();
        OutClass.innerClass inner = out.new innerClass();
        OutClass.staticInnerClass staticInner = new OutClass.staticInnerClass();
        inner.sayHello();
    }

}

class OutClass {
    public class innerClass {
        public innerClass() {
            System.out.println("i am innerClass");
        }

        public void sayHello() {
            System.out.println("hello innerClass");
        }
    }

    public static class staticInnerClass {
        public staticInnerClass() {
            System.out.println("i am staticInnerClass");
        }

        public void sayHello() {
            System.out.println("hello staticInnerClass");
        }
    }
}
