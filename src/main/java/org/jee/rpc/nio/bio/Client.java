package org.jee.rpc.nio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: HaoBin
 * @Date 2018/1/30 15:03
 */
public class Client {
    private static int DEFAULT_SERVER_PORT = 12345;

    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String expression) throws IOException {
        send(DEFAULT_SERVER_PORT, expression);
    }

    public static void send(int port, String expression) throws IOException {
        System.out.println("算术表达式为：" + expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            socket = new Socket(DEFAULT_SERVER_IP,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println("___结果为：" + in.readLine());
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            //一下必要的清理工作
            if(in != null){
                in.close();
                in = null;
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(socket != null){
                socket.close();
                socket = null;
            }
        }
    }
}
