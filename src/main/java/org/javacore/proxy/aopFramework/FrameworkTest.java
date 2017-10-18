package org.javacore.proxy.aopFramework;

import java.io.InputStream;
import java.util.Collection;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 23:56
 */
public class FrameworkTest {
    public static void main(String[] args) {
        InputStream inputStream = FrameworkTest.class.getResourceAsStream("/config.properties");
        Object bean = new BeanFactory(inputStream).getBeans("xxx");
        System.out.println(bean.getClass().getName());
        ((Collection) bean).clear();
    }
}
