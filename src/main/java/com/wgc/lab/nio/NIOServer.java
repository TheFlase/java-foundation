package com.wgc.lab.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * NIO 服务器教学示例（正确处理可读字节、部分写出、关闭 channel）
 */
public class NIOServer {
    private Selector selector;

    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.initServer(10101);
        nioServer.listen();
    }

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("服务器端启动成功!");
        while (true) {
            selector.select();
            Iterator<?> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();
                try {
                    handler(key);
                } catch (IOException e) {
                    System.out.println("处理连接异常，关闭通道: " + e.getMessage());
                    closeKey(key);
                }
            }
        }
    }

    public void handler(SelectionKey key) throws IOException {
        if (!key.isValid()) {
            return;
        }
        if (key.isAcceptable()) {
            handleAccept(key);
        } else if (key.isReadable()) {
            handlerRead(key);
        }
    }

    public void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel channel = server.accept();
        if (channel == null) {
            return;
        }
        channel.configureBlocking(false);
        System.out.println("新的客户端连接！");
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    public void handlerRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if (read > 0) {
            buffer.flip();
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            String msg = new String(data, StandardCharsets.UTF_8);
            System.out.println("服务器端接收到的消息是:" + msg);

            ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes(StandardCharsets.UTF_8));
            while (outBuffer.hasRemaining()) {
                int written = channel.write(outBuffer);
                if (written == 0) {
                    // 暂不可写，简单阻塞等待（教学示例；生产应切 OP_WRITE）
                    break;
                }
            }
        } else if (read == -1) {
            System.out.println("客户端关闭!");
            closeKey(key);
        }
        // read == 0：无数据，忽略
    }

    private void closeKey(SelectionKey key) throws IOException {
        if (key == null) {
            return;
        }
        key.cancel();
        if (key.channel() != null) {
            key.channel().close();
        }
    }
}
