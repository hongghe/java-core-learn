package org.javacore.base.innerclass;

/**
 * 内部类和静态内部类的使用
 * @Author: HaoBin
 * @Date 2017/11/9 14:51
 */
public class OutClassTest {
    static int a;

    int b;

    public static void test() {
        System.out.println("outer class static function");
    }

    public static void main(String[] args) {
        OutClassTest outClassTest = new OutClassTest();
        // 实例化内部类
        OutClassTest.InnerClass innerClass = outClassTest.new InnerClass();
        System.out.println(innerClass.getKey());

        // 调用静态内部类的静态变量
        System.out.println(InnerStaticClass.static_value);
        // 实例化静态内部类
        OutClassTest.InnerStaticClass innerStaticClass = new OutClassTest.InnerStaticClass();
        // 调用静态内部类非方法
        System.out.println(innerStaticClass.getValue());
        // 调用静态内部类静态方法
        System.out.println(OutClassTest.InnerStaticClass.getMessage());

    }

    /**
     * 内部类
     */
    public class InnerClass {
//        报错，只有静态内部类才能够声明静态成员
//        private static String string = "inner static";
        private int flag = 0;

        public InnerClass() {
            System.out.println("InnerClass create a:" + a);
            System.out.println("InnerClass create b:" + b);
            System.out.println("InnerClass create flag:" + flag);
            // 调用外部类的静态方法
            System.out.println("InnerClass call outer static function");
            test();
        }

        public String getKey() {
            return "no-static-inner";
        }
    }

    /**
     * 内部静态类
     */
    public static class InnerStaticClass {
        // 静态内部类可以有静态成员
        private static String static_value = "innerClass static value";

        private int flag = 0;

        public InnerStaticClass() {
            System.out.println("Static InnerClass create a:" + a);
//            静态内部类不能访问外部类的非静态成员
//            System.out.println("Static InnerClass create b:" + b);
            System.out.println("Static InnerClass create flag:" + flag);
            System.out.println("Static InnerClass static vlaue::" + static_value);
        }

        public int getValue() {
            // 访问外部类的静态方法
            test();
            return 1;
        }

        public static String getMessage() {
            return "static-inner";
        }
    }


}
