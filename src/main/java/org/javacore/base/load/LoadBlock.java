package org.javacore.base.load;

/**
 * @Author: HaoBin
 * @Date 2017/11/30 10:06
 */
public class LoadBlock {
    public LoadBlock() {
        System.out.println("构造函数");
    }

    {
        System.out.println("构造代码块");
    }


    static {
        System.out.println("静态代码块");
    }


    public static void main(String[] args) {
        LoadBlock A = new LoadBlock();
        LoadBlock B = new LoadBlock();
    }
}
