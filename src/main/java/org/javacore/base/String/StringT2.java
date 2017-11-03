package org.javacore.base.String;

/**
 * 首先要说明的是java中是没有指针的，java中只存在值传递，只存在值传递！！！
 * 然而我们经常看到对于对象（数组，类，接口）的传递似乎有点像引用传递，可以改变对象中某个属性的值。
 * 但是不要被这个假象所蒙蔽，实际上这个传入函数的值是对象引用的拷贝，即传递的是引用的地址值，所以还是按值传递。
 */
public class StringT2 {

    public static void main(String[] args) {
        StringObject sb = new StringObject();
        sb.setName("123");
        change(sb);
        System.out.println(sb.getName());
        sb.setAge(1);
        changeAge(sb);
        System.out.println(sb.getAge());
        String str = "i am jackson";
        changString(str);
        System.out.println(str);
        /**
         * java中实际上是没有引用传递的，不论是数组还是对象，传递的都是对象或数组引用的拷贝
         * 指向的是这个对象或者数组，以下例子把传递的数组指向另一个数组，原数组的值仍然没有改变
         * 如果把传递数组元素的值改变，原数组的值却改变了！
         */
        String[] strArr = {"hello ", "haobin"};
        changArr(strArr);
        for(int i=0; i<strArr.length; i++){
            System.out.println(strArr[i]);
        }
        changeArrChar(strArr);
        for(int i=0; i<strArr.length; i++){
            System.out.println(strArr[i]);
        }

    }

    public static void change(StringObject sb) {
        sb.setName("456");
    }
    public static void changeAge(StringObject sb) {
        sb.setAge(2);
    }
    public static void changString(String str) {
        str = "hello world";
    }
    public static void changArr(String[] strArr) {
        String[] newArr = new String[10];
        for(int i=0;i<10;i++){
            newArr[i] = i+"hello";
        }
        strArr = newArr;
        for(String item : strArr){
            System.out.println(item);
        }
    }
    public static void changeArrChar(String[] strArr) {
        strArr[0] = "hi hi";
    }
}
class StringObject {
    String name;
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
