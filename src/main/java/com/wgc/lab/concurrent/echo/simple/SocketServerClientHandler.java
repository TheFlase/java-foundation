package com.wgc.lab.concurrent.echo.simple;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/25
 **/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @program: com.io.socket.server
 * @description: 服务端客户消息处理线程类
 * @author: liujinghui
 * @create: 2019-02-16 11:02
 **/
public class SocketServerClientHandler extends Thread{

    //每个消息通过Socket进行传输
    private Socket clientConnectSocket;
    public SocketServerClientHandler(Socket clientConnectSocket){
        this.clientConnectSocket = clientConnectSocket;
    }

    @Override
    public void run(){
        try {
            InputStream inputStream = clientConnectSocket.getInputStream();
            String fileName = UUID.randomUUID().toString().substring(0,8)+".log";
            File userFile = new File("src/"+fileName);
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
            while (true) {
                //创建文件字节输出流
                FileOutputStream fos = new FileOutputStream(userFile);
                byte[] data = new byte[100];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息: " + message);
                    //开始写
                    byte[] bytes = message.getBytes();
                    //将byte数组中的所有数据全部写入
                    fos.write(bytes);
                    clientConnectSocket.getOutputStream().write(data);
                }
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}