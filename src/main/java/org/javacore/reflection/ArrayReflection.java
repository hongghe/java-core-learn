package org.javacore.reflection;

/**
 * 1. 对于元素同类型的数组，同维数组，class一样
 * 2. 不同维， class不同
 * 3. 不同维的，父类都是Object，一样
 * 4. 基本类型一维数组不能直接转换成Object[]
 */
public class ArrayReflection {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3};
        int[] a2 = new int[5];
        int[][] a3 = new int[2][3];
        double[] b1 = new double[2];

        System.out.println(a1.getClass() == a2.getClass()); //true
        System.out.println(b1.getClass());  // class [D
//        System.out.println(a1.getClass() == a3.getClass()); // 报错
        System.out.println(a1.getClass()); // class [I
        System.out.println(a3.getClass()); // class [[I
        System.out.println(a1.getClass().getSuperclass() == a3.getClass().getSuperclass()); // true
        System.out.println(a2.getClass().getSuperclass()); // class java.long.Object
    }
}
