package org.design_pattern.proxy.aopFramework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 23:27
 */
public class ProxyFactoryBean {
    // 委托类
    private Object target;
    // 实现接口
    private Advice advice;

    // 返回代理类
    public Object getProxy() {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method);
                Object retVal = method.invoke(target, args);
                advice.afterMethod(method);
                return retVal;
            }
        });
        return proxy;
    }

    public Object getTarget() {
        return target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setAdvice(Advice advice) {

        this.advice = advice;
    }
}
