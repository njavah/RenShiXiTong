package com.imooc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
  * 基于TCP实现登陆
  *  服务端
 */
public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;
            System.out.println("服务器即将启动，等待客服端的链接");
            while(true) {
                socket = serverSocket.accept();
                servicethread servicethread1 = new servicethread(socket);
                servicethread1.start();
                count++;
                System.out.println("客服端的数量:"+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
