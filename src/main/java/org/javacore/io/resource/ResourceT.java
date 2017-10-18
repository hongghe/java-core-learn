package org.javacore.io.resource;

import java.io.InputStream;

/**
 * @Author: HaoBin
 * @Date 2017/10/18 10:01
 */
public class ResourceT {
    public static void main(String[] args) {
        InputStream inputStream = ResourceT.class.getResourceAsStream("/test.properties");
        System.out.println(inputStream);
    }

}
