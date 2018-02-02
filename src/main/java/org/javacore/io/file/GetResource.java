package org.javacore.io.file;


import java.io.IOException;
import java.io.InputStream;

/**
 * Class.getResource是从当前.class目录查找
 * ClassLoader.getResource是从jar包根目录查找
 * @Author: HaoBin
 * @Date 2018/2/2 18:26
 */
public class GetResource {

    public static void main(String[] args) {
        InputStream is = GetResource.class.getResourceAsStream("/config.properties");
        String ss = GetResource.class.getResource("/config.properties").getPath();
        byte[] byteArray = new byte[1024];
        int len = -1;

        try {
            while ((len = is.read(byteArray)) != -1) {
                System.out.println(new java.lang.String(byteArray, 0 ,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
