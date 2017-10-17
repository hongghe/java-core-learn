package org.javacore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理
 * 实现步骤：
 * 1.定义一个委托类（RealSubject）和接口
 * 2.定义一个调用处理类（ProxyHandler）实现InvocationHandler接口
 * 3.生成代理对象，需要指定委托对象、实现的接口、处理器实例
 */

public class DynamicProxyDemo {

    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        ProxyHandler invocationHandler = new ProxyHandler(subject);
        // 创建代理对象
        Subject ProxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), invocationHandler);
        ProxySubject.request();
    }

}


/**
 * 接口
 */
interface Subject1 {
    void request();
}

/**
 * 委托类
 */
class RealsSubject implements Subject1 {
    @Override
    public void request() {
        System.out.println("====RealSubject======");
    }
}

/**
 * 代理类调用处理器
 */
class ProxyHandler implements InvocationHandler {

    private Subject subject;

    public ProxyHandler(Subject subject) {
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
