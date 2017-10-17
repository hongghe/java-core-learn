package org.javacore.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 11:28
 */
public class MyAdvice implements Advice {

    public long beginTime = 0;

    public static void main(String[] args) {
        Collection proxy3 = (Collection) getProxy(new ArrayList(), new MyAdvice());
        proxy3.add("111");
        proxy3.add("222");
        System.out.println(proxy3.size());
    }
    @Override
    public void beforMethod(Method method) {
        System.out.println(method.getName() + " before at " + beginTime);
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " cost total " + (endTime - beginTime));
    }

    private static Object getProxy(final Object targets, final Advice advice) {
        Object proxy = Proxy.newProxyInstance(targets.getClass().getClassLoader(), targets.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforMethod(method);
                Object retVal = method.invoke(targets, args);
                advice.afterMethod(method);
                return retVal;
            }
        });
        return  proxy;
    }
}
