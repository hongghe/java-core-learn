package org.javacore.proxy;


import java.lang.reflect.*;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 10:21
 */
public class ProxyTest {

    public static void main(String[] args) {
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazzProxy1);
        printConstructors(clazzProxy1);
        printMethod(clazzProxy1);
    }
    /**
     * @Auhtor: HaoBin
     * @Date: 2017/10/17 10:42
     * @Description: 打印构造方法列表
     */
    public static void printConstructors(Class clazz){
        System.out.println("------constructor list-------------");
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(getExecutableList(constructors));
    }

    /**
     * @Auhtor: HaoBin
     * @Date: 2017/10/17 10:45
     * @Description: 打印成员方法列表
     */
    public static void printMethod(Class clazz) {
        System.out.println("--------method list---------------");
        Method[] methods = clazz.getMethods();
        System.out.println(getExecutableList(methods));
    }

    /**
     * @Auhtor: HaoBin
     * @Date: 2017/10/17 10:25
     * @Description: 获取要打印列表的数;每行一个方法，按照func(arg1, arg2)的格式
     */
    public static String getExecutableList(Executable[] executables) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Executable executable : executables) {
            // return the name of the executable represented by this object
            String name = executable.getName();
            stringBuilder.append(name);
            stringBuilder.append("(");
            // Returns an array of Class objects that represent the formal parameter types, in declaration order, of the executable represented by this object.
            Class[] clazzParams = executable.getParameterTypes();
            for(Class clazzParam : clazzParams) {
                stringBuilder.append(clazzParam.getName()).append(",");
            }
            if (clazzParams != null && clazzParams.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")\n");
        }
        return stringBuilder.toString();
    }

    /**
     * 测试创建实例对象
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void createProxyInstance() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{
        /**
         * 方法1：先创建代理类，在使用反射创建实例对象
         */
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        Collection proxy1 = (Collection) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        /**
         * 方法2：直接使用newProxyInstance方法创建实例对象
         */
        Collection proxy2 = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), new Class[]{Collection.class}, new InvocationHandler() {
            ArrayList target = new ArrayList();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before invoke method: " + method.getName());
                return method.invoke(target, args);
            }
        });

        proxy2.add("aaa");
        proxy2.add("bbb");
        System.out.println(proxy2.size());
        System.out.println(proxy2);
        System.out.println(proxy2.getClass().getName());
    }
}
