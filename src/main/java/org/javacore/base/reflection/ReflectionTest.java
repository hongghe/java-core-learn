package org.javacore.base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射的基本使用
 * 一、获取CLass的方法
 *  1.类名.class
 *  2.对象名.getClass
 *  3.Class.forName("要加载的类")
 * 二、大致使用流程
 *  1. 用上述三种方法获取特定类的Class类，即该类对应的字节码
 *  2. 调用构造方法类Constructor的newInstance(Object... initargs)方法新建对象
 *  3. 调用CLass对象的getMethod(String name, Class<?>... parameterTypes)获取方法对象
 *  4. 调用方法对象类Method的invoke(Object obj, Object... args)方法，调用对象上相应的方法
 */

public class ReflectionTest {
    public final int  AGE = 1;

    public static void main(String[] args) {
        // Class是创建类的类型信息（比起class关键字是大写的）
        Class cl = null;
        try {
            cl = Class.forName("org.javacore.base.reflection.ReflectionTest");
            System.out.println("打印析构函数：");
            printConstructors(cl);
            System.out.println("打印方法：");
            printMethods(cl);
            System.out.println("打印字段：");
            printFields(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印Class对象的构造方法
     * @param cl
     */
    public static void printConstructors(Class cl){
        // 返回类所有的构造方法
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors){
            // 返回析构方法名称
            String name = c.getName();
            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // 获取析构方法的参数对象列表数组
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length;i++){
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印对象所有的方法
     * @param cl
     */
    public static void printMethods(Class cl){
        // 获取类所有方法对象数组
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            // 获取方法返回对象
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() +" " + name + "(");

            // 获取方法的参数对象列表数组
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length;i++){
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class clazz){
        // 获取字段Field对象数组
        Field[] fields = clazz.getFields();
        for (Field field : fields){
            // 获取字段声明类型对象
            Class type = field.getType();
            // 获取字段名称
            String name = field.getName();

            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(type.getName() + " " + name);
        }
    }
}
