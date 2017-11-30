package org.javacore.base.load;

/**
 * @Author: HaoBin
 * @Date 2017/11/30 10:12
 */
public class InitialClass {
    // 静态变量
    public static String staticField = "staticField";

    // 普通变量
    public String field = "field";

    static {
        System.out.println(staticField);
        System.out.println("static block init");
    }

    {
        System.out.println(field);
        System.out.println("block init");
    }

    public InitialClass() {
        System.out.println("Constructor init");
    }

    public static void main(String[] args) {
        new InitialClass();
    }
}
