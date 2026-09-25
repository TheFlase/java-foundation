package com.wgc.lab.concurrent.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();  //等待客户连接
                // 为每一个客户端创建一个线程
                Thread workThread = new Thread(new Handles(socket));
                //启动线程
                workThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws IOException {
        //new EchoServer().service();
        new EchoPooledServer().service();
//        new EchoIterServer().service();

    }


    private class Handles implements Runnable {
        private Socket socket;

        public Handles(final Socket socket) {
            this.socket = socket;
        }

        public String echo(String msg) {
            return "echo:" + msg;
        }

        private PrintWriter getWriter(Socket socket) throws IOException {
            OutputStream socketOut = socket.getOutputStream();
            return new PrintWriter(socketOut, true);
        }

        private BufferedReader getReader(Socket socket) throws IOException {
            InputStream socketIn = socket.getInputStream();
            return new BufferedReader(new InputStreamReader(socketIn));
        }

        @Override public void run() {
            try {
                System.out.println("New connection accepted "
                        + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader br = getReader(socket);
                PrintWriter pw = getWriter(socket);
                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                    pw.println(echo(msg));
                    if (msg.equals("bye")) //如果客户发送的消息为“bye”，就结束通信
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("服务线程结束");

        }
    }

}
