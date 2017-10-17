package org.javacore.proxy.aop;

import java.lang.reflect.Method;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 11:27
 */
public interface Advice {
    void beforMethod(Method method);
    void afterMethod(Method method);
}
