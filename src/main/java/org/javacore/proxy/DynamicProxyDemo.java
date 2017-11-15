package org.javacore.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理
 * 实现步骤：
 * 1.定义一个委托类（RealsSubject）和接口
 * 2.定义一个调用处理类（ProxyHandler）实现InvocationHandler接口
 * 3.生成代理对象，需要指定委托类的加载器、实现接口、处理器实例
 */

public class DynamicProxyDemo {

    public static void main(String[] args) {
        Class<?>[] c1 = RealsSubject.class.getInterfaces();
        System.out.println(c1[0]);
        DynamicSubject subject = new RealsSubject();
        // 调用类
        ProxyHandler invocationHandler = new ProxyHandler(subject);
        // 创建代理对象
        DynamicSubject proxySubject = (DynamicSubject) Proxy.newProxyInstance(RealsSubject.class.getClassLoader(), RealsSubject.class.getInterfaces(), invocationHandler);
        proxySubject.request();
        // 可以看到代理类是$Proxy0，我们用到的就是这动态代理类
        System.out.println("代理类:" + proxySubject.getClass().toString());
        System.out.println("代理类的属性：");
        Field[] fields = proxySubject.getClass().getDeclaredFields();
        for(Field field : fields) {
            System.out.print(field.getName() + ",");
        }
        System.out.println("\n代理类的方法：");
        Method[] methods = proxySubject.getClass().getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + ",");
        }
        System.out.println("\n代理类实现的接口：");
        Class<?>[] interfaces = proxySubject.getClass().getInterfaces();
        for (Class infs : interfaces) {
            System.out.println(infs);
        }
    }

}


/**
 * 接口
 */
interface DynamicSubject {
    void request();
    void request1();
}

/**
 * 委托类
 */
class RealsSubject implements DynamicSubject {
    @Override
    public void request() {
        System.out.println("====RealSubject======");
    }

    @Override
    public void request1() {
        System.out.println("=====another subject=======");
    }
}

/**
 * 代理类调用处理器
 */
class ProxyHandler implements InvocationHandler {

    private DynamicSubject subject;

    public ProxyHandler(DynamicSubject subject) {
        this.subject =subject;
    }

    /**
     * 代理类的实例，要代理的方法，和参数
     * 这方法不是我们显示的调用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======befor======");
        Object result = method.invoke(subject,args);
        System.out.println("======after======");
        return result;
    }
}
