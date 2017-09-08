package org.javacore.object;

/**
 * 暂时理解为private属性和方法是不会被继承的
 */
public class Sun extends Parent{
    private String name;

    Sun(String name, String lastName, char blood){
        super(lastName, blood);
        this.name = super.getLastName() + name;
    }

    @Override
    public String toString() {
        return getClass().getName();
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Sun obj2 = new Sun("bin", "hao", 'B');
        obj2.age = 23;
        System.out.println(obj2.name);
        System.out.println(obj2.age);
        System.out.println("obj2 is " + obj2);
    }
}
