package org.javacore.proxy.aopFramework;

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
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
}
