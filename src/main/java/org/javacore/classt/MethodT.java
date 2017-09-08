package org.javacore.classt;


/**
 *  泛型方法，在调用方法的时候指明泛型的具体类型
 *  1) public与返回值之间的<T>非常重要，可以理解为此方法为泛型方法
 *  2) 只有声明了<T>的方法才是泛型方法， 泛型类中使用了泛型的的成员方法并不是泛型方法
 *  3) <T>表名该方法使用泛型类型T，此时才可以在泛型方法中使用泛型类型T
 *  4) 与泛型类型相同， 此处的T可以使用任意标识，常见的如T,E,K,V等
 */

public class MethodT {

    public static  <T>T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }

    public <T> void showString(T value) {
        System.out.println(value);
    }

    public static void main(String[] args) throws ClassNotFoundException,InstantiationException, IllegalAccessException{
        Object obj = MethodT.genericMethod(Class.forName("org.javacore.classt.MethodT"));
        System.out.println(obj);
    }
}
