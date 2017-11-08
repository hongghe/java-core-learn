package org.javacore.base.templateclass;


import java.util.Random;

/**
 * 泛型测试
 * @Author: HaoBin
 * @Date 2017/11/8 16:08
 */
public class Template {
    public static void main(String[] args) {
        // 实例化一个泛型类
        Generic<Integer> integerGeneric = new Generic<Integer>(123);
        Generic<String> stringGeneric = new Generic<String>("key");


    }
}

/**
 * 泛型类
 * @param <T>
 */
class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}

/**
 * 泛型接口
 * @param <T>
 */
interface GenericInterface<T> {
    public T next();
}

/**
 * 实现泛型接口，未传入泛型实参时，声明类需要将泛型的声明加入类中
 * @param <T>
 */
class FruitGenerator<T> implements GenericInterface {
    @Override
    public Object next() {
        return null;
    }
}

/**
 * 传入泛型实参，需要将所有的泛型都转换成传入的实参类型
 */
class FruitGenerator1 implements GenericInterface<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
