package org.javacore.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Jeff Lee
 * @since 2015-11-2 16:43:41
 * 	获取Class方法案例
 */
public class ShowMethods {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("org.javacore.rtti.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method m : methods)
                System.out.println(m.toGenericString());
            for (Constructor constructor : constructors)
                System.out.println(constructor.toGenericString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
