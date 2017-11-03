package org.javacore.base.String;

/**
 * @author BYSocket
 * @since 2016-01-06 20:07:00
 * 对象做为参数传递是传递的对象的引用，会修改对象的值
 * 基本数据类型
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
