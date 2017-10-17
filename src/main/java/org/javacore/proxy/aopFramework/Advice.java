package org.javacore.proxy.aopFramework;

import java.lang.reflect.Method;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 23:19
 */
public interface Advice {
    void beforeMethod(Method method);
    void afterMethod(Method method);
}

