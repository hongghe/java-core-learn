package org.javacore.base.templateclass;

import java.util.ArrayList;

/**
 * 泛型擦除的原因，只保留了基本类型Object，可以通过反射来添加其他类型（Integer可以添加String）
 *
 * @Author: HaoBin
 * @Date 2017/11/29 18:54
 */
public class AcceptT {

    public static void main(String[] args) throws Exception{
        referrence();
    }

    public static void reflectAdd() throws Exception{
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.getClass().getMethod("add", Object.class).invoke(arrayList, "abc");
        for (int i = 0; i <arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }


    /**
     * 用引用调用泛型方法就会对这个引用调用的方法进行类型检测而无关它真正引用的对象
     */
    public static void referrence() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("123");
//        arrayList1.add(123);
        String str1 = arrayList1.get(0);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("123");
//        arrayList2.add(123)
        String obj2 = arrayList2.get(0);

        // 先检查在擦除是针对引用的
        ArrayList arrayList3 = new ArrayList<String>();
        arrayList3.add("123");
        arrayList3.add(123);
        Object obj3 = arrayList3.get(0);
        System.out.println(obj3);
    }

    /**
     * 泛型中参数化类型无法支持继承关系，因为泛型的设计初衷就是为了解决 Object 类型转换的弊端而存在，
     * 如果泛型中参数化类型支持继承操作就违背了设计的初衷而继续回到原始的 Object 类型转换弊端
     */
    public static void inherit() {
        ArrayList<Object> arrayList1 = new ArrayList<>();
        arrayList1.add(new Object());
        arrayList1.add(new Object());
        // 泛型参数没有继承关系
//        ArrayList<String> arrayList2 = arrayList1;

        ArrayList<String> arrayList3 = new ArrayList<String>();
        arrayList3.add("abc");
        arrayList3.add(new String());
        // 编译通不过
//        ArrayList<Object> arrayList4 = arrayList3;

     // 编译不通过
//        ArrayList<String> arrayList5 = new ArrayList<Object>();
        
    }
}
