package org.javacore.base.innerclass;


import org.javacore.rtti.ClassInitialization;

import java.util.Random;

/**
 * 各种静态变量加载顺序
 *
 * @Author: HaoBin
 * @Date 2017/11/3 16:41
 */

class Initable {
    static {
        System.out.println("static code block");
    }

    static final int staticFinal = 10;

    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);

    static {
        System.out.println("Initialing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 100;

    static {
        System.out.println("Initialing Initable2");
        a = 1;
    }

    static int a = 7;
}

class Initable3 {
    static int staticNonFinal = 11;

    static {
        System.out.println("Initialing Initable3");
    }

}


public class LoadTurn {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("org.javacore.base.innerclass.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
        System.out.println(Initable2.a);
    }
}
