package org.javacore.anotation;

/**
 * 使用注解
 * @Author: HaoBin
 * @Date 2017/11/27 14:45
 */
@Definination(name = "type", gid = Long.class) //类注解
public class UseAnotation {
    // 类成员注解
    @Definination(name = "param", id = 1, gid = Long.class)
    private Integer age;

    // 构造方法注解
    @Definination(name = "construct", id = 2, gid = Long.class)
    public UseAnotation() {}

    // 类方法注解
    @Definination(name = "public method", id = 3, gid = Long.class)
    public void publicClassMethod() {

    }

    // 类方法注解
    @Definination(name = "protected method", id = 4, gid = Long.class)
    protected void protectedClassMethod() {}

    // 类方法注解
    @Definination(name = "private method", id = 5, gid = Long.class)
    private  void privateClassMethod() {}
}
