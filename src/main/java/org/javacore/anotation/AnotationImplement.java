package org.javacore.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 注解具体的实现
 *
 * @Author: HaoBin
 * @Date 2017/11/27 14:53
 */
public class AnotationImplement {
    /**
     * 打印UseAntation中所有的类注解
     */
    public static void parseTypeAnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("org.javacore.anotation.UseAnotation");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            Definination definination = (Definination) annotation;
            System.out.println("id = " + definination.id() + " ;name = " + definination.name() + " ;gid = " + definination.gid());
        }
    }

    public static void parseMethodAnotation() {
        Method[] methods = UseAnotation.class.getDeclaredMethods();
        for (Method method : methods) {
            // 判断方法中是否有指定注解类型的注解
            boolean hasAnnotation = method.isAnnotationPresent(Definination.class);
            if (hasAnnotation) {
                // 根据注解类型返回方法的指定类型注解
                Definination annotation = method.getAnnotation(Definination.class);
                System.out.println("method = " + method.getName()
                    + " ; id = " + annotation.id() + " ; description = "
                    + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }

    public static void parseConstructAnnotation() {
        Constructor[] constructors = UseAnotation.class.getConstructors();
        for (Constructor constructor : constructors) {
            boolean hasAnnotation = constructor.isAnnotationPresent(Definination.class);
            if (hasAnnotation) {
                Definination annotation = (Definination) constructor.getAnnotation(Definination.class);
                System.out.println("constructor = " + constructor.getName()
                    + " ; id = " + annotation.id() + " ; description = "
                    + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("class annotation:");
        parseTypeAnotation();
        System.out.println("method annotation: ");
        parseMethodAnotation();
        System.out.println("constructor annotation: ");
        parseConstructAnnotation();
    }
}
