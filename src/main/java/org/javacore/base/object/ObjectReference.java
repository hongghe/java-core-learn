package org.javacore.base.object;

/**
 * 对象的引用
 * @Author: HaoBin
 * @Date 2017/11/7 18:32
 */

class objT {
    public objT obj;
    String name;

    objT(String name) {
        this.name = name;
    }

    // 打印name属性和obj的name属性
    @Override
    public String toString() {
        return super.toString() + "  [name is: " + this.name + ", objName is: " + this.obj.name;
    }
}

public class ObjectReference {
    public static void main(String[] args) {
        objT a = new objT("obja");
        objT b = new objT("objb");
        a.obj = b;
        System.out.println(a);
        b.name = "objc";
        System.out.println(a);
    }
}


