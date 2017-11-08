package org.javacore.base.templateclass;

/**
 * 泛型方法
 *
 * @Author: HaoBin
 * @Date 2017/11/8 21:12
 */
public class TemplateMethod {

    /**
     * 泛型方法，与泛型类的方法不同的是 public后面 跟上 <T>
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key:" + container.getKey());
        T test = container.getKey();
        return test;
    }

    /**
     * 这不是泛型方法，只是一个泛型类当做形参
     */
    public void showKeyValue1(Generic<Number> obj) {
        System.out.println("key value is" + obj.getKey());
    }

    /**
     * 这也不是一个泛型方法，使用了通配符？作为实参， 表示匹配所有的泛型
     */
    public void showKeyValue2(Generic<?> obj) {
        System.out.println("key value is " + obj.getKey());
    }

    public static void main(String[] args) {

    }
}
