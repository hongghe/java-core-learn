package org.javacore.proxy;

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
        DynamicSubject subject = new RealsSubject();
        // 调用类
        ProxyHandler invocationHandler = new ProxyHandler(subject);
        // 创建代理对象
        DynamicSubject ProxySubject = (DynamicSubject) Proxy.newProxyInstance(RealsSubject.class.getClassLoader(), RealsSubject.class.getInterfaces(), invocationHandler);
        ProxySubject.request();
    }

}


/**
 * 接口
 */
interface DynamicSubject {
    void request();
}

/**
 * 委托类
 */
class RealsSubject implements DynamicSubject {
    @Override
    public void request() {
        System.out.println("====RealSubject======");
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


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======befor======");
        Object result = method.invoke(subject,args);
        System.out.println("======after======");
        return result;
    }
}
