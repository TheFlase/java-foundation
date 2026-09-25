package com.wgc.lab.nio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 7/5/2018.
 * desc:传统socker服务端
 */
public class OioServer {
    public static void main(String[] args) throws Exception{
        //创建socket服务,监听10101端口,
        ServerSocket server = new ServerSocket(10101);
        System.out.println("服务器启动");

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            //获取一个套接宇
            final Socket socket = server.accept();
            System.out.println("来了一个新客户端");
            //业务处理
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    /**
     * 读取数据
     * @param socket
     */
    private static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream= socket.getInputStream();
            while (true) {
                //读取数据(阻塞)
                int read = inputStream.read(bytes);
                if(read != -1) {
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println("Socket关闭");
                socket.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
