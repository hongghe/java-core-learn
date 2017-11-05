package org.javacore.base.tool;

import java.util.Random;

/**
 * 随机数的使用
 * @Author: HaoBin
 * @Date 2017/11/3 18:20
 */
public class RandomT {
    public static void main(String[] args) {
        // 生成2的31次方-1范围内的数。一个是符号位
        Random r1 = new Random();
        Random r2 = new Random(10);
        System.out.println(r1.nextInt(100));
        // 0，int] 范围的随机数
        System.out.println(r2.nextInt(240));

    }
}
