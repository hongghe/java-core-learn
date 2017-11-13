package org.javacore.base.templateclass;

import java.util.ArrayList;

/**
 * 泛型擦除： java的泛型基本上完全在编译器中实现，用于编译器执行类型检查和类型判断，然后生成普通的非泛型的字节码，这种实现技术为“擦除”(erasure)。
 *
 * 泛型的参数推断：
 * 1.当某个类型变量只在整个参数列表的所有参数和返回值中的一处被应用了，那么根据调用方法时该处的实际应用类型来确定。即直接根据调用方法时传递的参数类型或返回值来决定泛型参数的类型。
 * eg: swap(new String[3],1,2) -> static <E> void swap(E[]a,int i,int j)
 * 2. 当某个类型变量在整个参数列表的所有参数和返回值中的多处被应用了，如果调用方法时这么多处的实际应用类型都 对应同一种类型，则泛型参数的类型就是该类型。
 * eg: add(3,5) -> static <T> T add(T a,T b)
 * 3. 当某个类型变量在整个参数列表的所有参数和返回值中的多处被应用了，如果调用方法时这么多处的实际应用类型 对应不同的类型,且没有返回值，则取多个参数中的最大交集类型，即第一个公共父类。
 * eg: int x = add(3,3.5) -> static <T> T add(T a,T b) , x类型改为Number则编译通过
 * @Author: HaoBin
 * @Date 2017/11/13 18:25
 */
public class EraseTemplate {
    public static void main(String[] args) {
        EraseTemplate obj = new EraseTemplate();
        obj.testType();
        obj.testReference();
    }

    /**
     * 泛型是提供给javac编译器使用的，限定集合的输入类型，编译器编译带类型说明的集合时会去掉“类型”信息。
     * 使用泛型可跳过编译器，像某个泛型集合里面加入其它类型的数据。
     */
    public void testType() {
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        ArrayList<String> collection2 = new ArrayList<String>();

        System.out.println(collection1.getClass() == collection2.getClass());   // true
        System.out.println(collection2.getClass().getName()); // java.util.ArrayList,并无实际类型信息
    }


    /**
     * 只有引用类型才能作为泛型方法的实际参数
     */
    public void testReference() {
        swap(new String[]{"111", "222"}, 0, 1);//编译通过
        //swap(new int[]{1,2},0,1);
        //编译不通过,因为int不是引用类型
        swap(new Integer[]{1, 2}, 0, 1);//编译通过
    }

    // 交换数组a的第i和第j个元素
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
