package org.design_pattern.proxy.aopFramework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: HaoBin
 * @Date 2017/10/17 23:22
 */
public class BeanFactory {
    Properties properties = new Properties();

    public BeanFactory(InputStream inputStream) {
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBeans(String name) {
        String className = properties.getProperty(name);
        Object bean = null;
        try {
            // 实例化配置文件的类
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 如果是ProxyFactoryBean的实例
        if(bean instanceof ProxyFactoryBean) {
            ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;
            Advice advice = null;
            Object target = null;
            try {
                // advice Myadvice
                advice = (Advice) Class.forName(properties.getProperty(name + ".advice")).newInstance();
                // target any collection
                target = Class.forName(properties.getProperty(name + ".target")).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            proxyFactoryBean.setAdvice(advice);
            proxyFactoryBean.setTarget(target);
            // 获得动态代理类实例
            Object proxy = ((ProxyFactoryBean) bean).getProxy();
            return proxy;
        }
        return bean;
    }
}
