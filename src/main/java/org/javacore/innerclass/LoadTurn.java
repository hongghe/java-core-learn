package org.javacore.innerclass;


import org.javacore.rtti.ClassInitialization;

/**
 * 各种静态变量加载顺序
 * @Author: HaoBin
 * @Date 2017/11/3 16:41
 */

class Initable {
    static {
        System.out.println("static code block");
    }

    static final int staticFinal = 10;

    static final int staticFianl2 = ClassInitialization.random.nextInt(1000);

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


}
