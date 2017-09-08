package org.javacore.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * @author Jeff Lee
 * @since 2015-11-9 10:45:19
 * 反射扩容对象数组
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] str = {"a","b","c"};
        str = (String[]) goodCopyOf(str,10);
        System.out.println(Arrays.toString(str));
    }

    public static Object goodCopyOf(Object a,int newLength){
        // 获取Class对象
        Class cl = a.getClass();
        // 如果不是数组对象，则返回null;
        if (!cl.isArray()) return null;
        // 获取数组组件对象
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        // 复制数组
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
