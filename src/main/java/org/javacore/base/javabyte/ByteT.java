package org.javacore.base.javabyte;

/**
 * 位运算
 */
public class ByteT {
    public static void main(String[] args) {
        // 左移，  101 << 2,   左移两位 1 0100 = 2^2+2^4=20
        // 左移低位补0，右移高位补0
        System.out.println(5 >> 2);
        // 与运算， 101 & 011 = 001  ，两个都是1才为1否则为0
        System.out.println(5 & 3);
        // 或运算， 001 | 010 = 011  ，只要有一个位1就为1
        System.out.println(1 | 2);
        // 异或运算, 101 ^ 011 = 110 ， 两个数相反为1相同为0
        System.out.println(5 ^ 3);
        // 非运算， 按位取反
        // 负数的二进制计算方法（补码）：反码加一
        System.out.println(~5);
    }
}
