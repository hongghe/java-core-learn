package org.jee.rpc.nio.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统IO：BIO
 * @Author: HaoBin
 * @Date 2018/1/30 13:59
 */
public class ServerNormal {

    private static int DEFAULT_PORT = 12345;

    private static ServerSocket server;

    public static void start() throws IOException {

    }

    public synchronized static void start(int port) throws IOException{
        if (ServerNormal.server != null)
            return;
        try {
            //通过构造函数创建ServerSocket
            //如果端口合法且空闲，服务端就监听成功
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            //通过无线循环监听客户端连接
            //如果没有客户端接入，将阻塞在accept操作上。
            while(true){
                Socket socket = server.accept();
                //当有新的客户端接入时，会执行下面的代码
                //然后创建一个新的线程处理这条Socket链路
                new Thread(new ServerHandler(socket)).start();
            }
        } finally {
            //一些必要的清理工作
            if(ServerNormal.server != null){
                System.out.println("服务器已关闭。");
                ServerNormal.server.close();
                ServerNormal.server = null;
            }
        }

    }
}
