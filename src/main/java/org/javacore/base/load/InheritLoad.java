package org.javacore.base.load;

/**
 * @Author: HaoBin
 * @Date 2017/11/30 10:34
 */
class HelloA {
    public HelloA() {
        System.out.println("A's constructor");
    }

    {
        System.out.println("A's code block");
    }

    static {
        System.out.println("A's static code block");
    }
}


public class InheritLoad extends HelloA{
    public InheritLoad() {
        System.out.println("son constructor");
    }

    {
        System.out.println("son's code block");
    }

    static {
        System.out.println("son's static code block");
    }

    public static void main(String[] args) {
        InheritLoad obj = new InheritLoad();
    }
}
