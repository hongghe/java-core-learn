package org.javacore.Generic;

import java.util.ArrayList;

/**
 * java泛型
 * ArrayList<E> -- 泛型类型
 * ArrayList    -- 原始类型
 * E            -- 类型参数
 * <>           -- typeof
 * ArrayList<Integer> -- 参数化的类型
 * Integer      -- 实际类型
 */

public class GenericT {

    public static void main(String[] args) {
        /**
         * ? 通配符表示任意类型，使用？通配符可以引用各种参数化类型
         * extends 限定通配符的上边界，实际类型是该类或者该类的子类
         * super   限定通配符的下边界，实际类型是该类或者该类的父类
         */
        ArrayList<? extends Number> collection1 = new ArrayList<Integer>();
//        ArrayList<? extends Number> collection2 = new ArrayList<String>();   编译不通过
        ArrayList<? super Integer> collection3 = new ArrayList<Number>();
//        ArrayList<? super Integer> collection4 = new ArrayList<String>();    编译不通过

        GenericT obj = new GenericT();
        obj.testType();
    }


    /**
     * 类型擦除，编译器执行类型检查和类型判断，然后生成普通的非泛型的字节码
     */
    public void testType() {
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        ArrayList<String> collection2 = new ArrayList<String>();
        System.out.println(collection1.getClass() == collection2.getClass());   //true
        System.out.println(collection2.getClass().getName());   // java.util.ArrayList
    }

    /**
     * 利用反射可以跳过编译器，往某个泛型集合中加入其它数据类型
     */
    public void reflectionTest() {
        swap(new String[]{"111", "222"}, 1, 2);
        swap(new Integer[]{111, 222}, 1, 2);
//        swap(new Int[]{111, 222}, 1, 2); 编译不通过，int不是引用类型

    }

    public <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 基本类型有自动装箱和拆箱机制，有时候也可以作为实参传递
     * 当实参不一致时，T取交集，即第一个共同的父类
     */
    public void boxT() {
        int a = biggerOne(3, 5);
        // int和double，取交集Number
        Number b = biggerOne(3, 3.5);
        // String和int 取交集Object
        Object c = biggerOne("1", 2);
    }

    public <T> T biggerOne(T x, T y) {
        return y;
    }

    /**
     * 类型参数的类型推断（编译器判断泛型方法的实际类型参数的过程）
     *
     * 1.当某个类型变量只在整个参数列表的所有参数的返回值的一处被采用了，那么根据调用方法时该处的实际应用类型来确定。
     * 即直接根据调用方法时传递的参数类型或返回值来决定泛型参数的类型。例如：
     * swap(new String[3], 1, 2) -> static <E> void swap(E[]a, int i, int j)
     *
     * 2.当某个类型变量在整个参数列表的所有参数和返回值多处被应用了，如果调用方法时这么多处
     */

}
