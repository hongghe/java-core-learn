package org.design_pattern.proxy.aopFramework;

import java.lang.reflect.Method;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 23:20
 */
public class MyAdvice implements Advice {
    long beginTime = 0;
    @Override
    public void beforeMethod(Method method) {
        System.out.println(method.getName() + " before at " + beginTime);
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " after at " + (endTime - beginTime));
    }
}
