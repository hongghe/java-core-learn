package org.javacore.base.copy;
/****
 * 如果是对象直接的赋值就是浅拷贝
 * 如果是调用了Object类的clone方法就是深拷贝，如果调用clone方法的类的属性里面有Object，
 * 需要对该属性调用clone方法
 */
class Family implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     * 如果属性里面没有Object类型，直接调用object的clone方法就是深拷贝
     * @return
     */
    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

class Student implements Cloneable {
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * 深拷贝
     * 如果类的属性里面有Object，需要对Object类再次进行clone，否则还是浅拷贝
     */
    @Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }
}

public class CopyT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");
        Student student2 = (Student) student1.clone();
//        直接赋值是浅拷贝
//        Student student2 = student1;
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());
    }
}
