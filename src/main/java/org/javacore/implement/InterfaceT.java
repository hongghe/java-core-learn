package org.javacore.implement;

/**
 * 如果类实现的两个接口中有同样的方法（只要其中一个接口给了方法的实现），则需要在类中重写这个方法
 * 如果超类和接口有同样的方法，则会用超类的方法（类优先原则）
 */
interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}

interface Person {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}

class People {
    public String getName() {
        return getClass().getName();
    }
}

public class InterfaceT extends People implements Named,Person{
//    @Override
//    public String getName() {
//        return Person.super.getName();
//    }

    public static void main(String[] args) {
        InterfaceT obj = new InterfaceT();
        System.out.println(obj.getName());
    }
}
