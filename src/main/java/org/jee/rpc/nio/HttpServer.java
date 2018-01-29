package org.jee.rpc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * 简单http服务器
 *
 * @Author: HaoBin
 * @Date 2018/1/29 11:16
 */
public class HttpServer {

    static int PORT = 8088;

    static int BUFFER_SIZE = 1024;

    static String CHARSET = "utf-8"; // 编码

    CharsetDecoder decoder; // 解码

    private int _port;

    private ServerSocketChannel channel;

    private Selector selector;

    private  ByteBuffer buffer;

    public HttpServer(int port) throws IOException{
        this._port = port;
        this.buffer = ByteBuffer.allocate(BUFFER_SIZE);
        this.decoder = Charset.forName(CHARSET).newDecoder();
        // 打开selector
        this.selector = Selector.open();
    }


    /**
     * 单线程服务，通过单一个线程同时为多路复用IO流服务
     * 1、此方式适合：IO密集型的操作：如代理服务.
     * 2、相信大家写过：使用socket的聊天程序:
     * 即accept()一个socket后，new一个Thread为该socket服务，
     * 此方式适合：CPU密集型的操作，如需要处理大量业务、计算
     */
    public void listen() throws IOException{
        this.channel = ServerSocketChannel.open();
        ServerSocket socket = channel.socket();
        socket.bind(new InetSocketAddress(_port));
        // 使用非阻塞模式，多道io
        channel.configureBlocking(false);
        System.out.println("server is open.....");
        while (true) {
            // 非阻塞模式，如果没有连接，立即返回，与socket.accept()(会一直阻塞在这里)不同
            SocketChannel client = channel.accept();
            if (client != null) {
                System.out.println("client port --->" + client.getRemoteAddress());
                // 注册到selector
                this.registerClient(client);
            }
            service();
        }
    }

    /**
     * 注册客户端channel到selector
     * 有四个事件: Connect、 Accept、 Read、 Write
     * @param client
     * @throws IOException
     */
    public void registerClient(SocketChannel client) throws IOException {
        // 设置为非阻塞
        client.configureBlocking(false);
        // selector事件
        client.register(selector, SelectionKey.OP_READ);
    }

    /**
     * 遍历各客户端通道
     * select()阻塞到至少有一个通道在你注册的事件上就绪了
     * select(long timeout) 多设置一个阻塞时间(毫秒)
     * selectNow() 不阻塞，有无都返回。
     */
    private void service() throws IOException{
        if (this.selector.selectNow() > 0) {
            Set<SelectionKey> keys = this.selector.selectedKeys();
            System.out.println("the selector length:" + keys.size());
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                SocketChannel client = (SocketChannel) key.channel();

                if (key.isReadable()) {
                    this.read(key);
                } else if (key.isWritable()) {
                    // write
                    this.write(key);
                }

            }
        }
    }

    /**
     * 读信息
     */
    private void read(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        this.buffer.clear();

        int c = client.read(this.buffer);
        if (c > 0) {
            // flip将Buffer从写模式切换到读模式
            buffer.flip();
            CharBuffer charBuffer = this.decoder.decode(this.buffer);
            // 接受请求
            System.out.println(charBuffer.toString());
            key.attach("ack syn....");
            // 改变自身关注事件
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else {
            client.close();
        }
        buffer.clear();
    }

    /**
     * 响应信息
     */
    private void write(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        String handle = (String) key.attachment();//取出read方法传递的信息。
        String res = Response.getMsg();
        if (handle != null) {
            res = res + "\r\n" + handle;
        }

        ByteBuffer block = ByteBuffer.wrap(res.getBytes());
        client.write(block);
        client.close();
        // 改变自身关注事件，可以用位或操作|组合时间
        //key.interestOps(SelectionKey.OP_READ);
    }

    public static void main(String[] args) {
        try {
            System.out.println("正在启动服务...");
            HttpServer server = new HttpServer(PORT);
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
