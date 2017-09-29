package org.javacore.object;

/**
 *
 *  对象的引用
 */
public class ObjListT {

    public static void main(String[] args) {
        objT a = new objT("obja");
        objT b = new objT("objb");
        a.obj = b;
        System.out.println(a);
        b.name = "objc";
        System.out.println(a);
    }
}

class objT {
    public objT obj;
    String name;
    objT(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "  [name is: " + this.name + ", objName is: " + this.obj.name;
    }
}
