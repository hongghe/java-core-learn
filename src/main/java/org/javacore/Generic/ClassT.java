package org.javacore.Generic;


import java.util.Random;

/**
 * 泛型
 * 泛型类，泛型接口，泛型方法
 */

public class ClassT {
    // 用...来替代多参数传递
    public static <T>T getMiddle(T... a){
        return a[a.length / 2];
    }


    public static void main(String[] args) {
//        System.out.println( ClassT.<String>getMiddle("jon", "si", "lida"));
//
//        Generic<String> genericString = new Generic<>("key_value");
        // 泛型的类型参数只能是类，不能是简单类型
//        Generic<Integer> genericInteger = new Generic<>(123);
//        System.out.println(genericString.getKey());
//        System.out.println(genericInteger.getKey());
        // 使用泛型的时候可以不用传入泛型实参，在泛型类中定义的方法或成员变量就不会有类型限制（任意类型）
//        Generic gen = new Generic("i am string");
//        Generic gen1 = new Generic(150);
//        Generic gen2 = new Generic(55.555);
//        Generic gen3 = new Generic(false);
//        System.out.println(gen.getKey());
//        System.out.println(gen1.getKey());
//        System.out.println(gen2.getKey());
//        System.out.println(gen3.getKey());
    }
}

/**
 * 泛型类
 * @param <T>
 *
 * 定义泛型类T字母可以写成随便的标识
 * 在实例化泛型类的时候，需要指明T的类型
 */
class Generic<T>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return this.key;
    }

    /**
     *  类型通配符？代表类型实参，类似于Object，通用类型
     */
    public void showValue(Generic<?> obj) {
        System.out.println(obj.getKey());
    }
}


/**
 * 泛型接口
 */
interface Generator<T> {
    public T next();
}

/**
 * 当实现泛型接口未传入泛型实参时，在声明类的时候，需要将泛型的声明也一起加到类里面
 * 如果不声明，例如： calss FruitGenrator implements Genrator<T>， 会报错
 */
class FruitGenerator<T> implements Generator<T> {
    @Override
    public T next() {
        return null;
    }
}

/**
 * 实现泛型类传入泛型实参，则所有使用泛型的地方都要替换成传入的实参类型
 */
class vegetablesGenrator implements Generator<String> {
    private String[] vegetables = {"protato", "cabages", "plants"};

    @Override
    public String next() {
        Random rand = new Random();
        return  vegetables[rand.nextInt(3)];
    }
}


