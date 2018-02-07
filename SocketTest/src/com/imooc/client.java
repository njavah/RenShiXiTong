package com.imooc;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
  * 基于TCP实现登陆
  *  客服端
 */
public class client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.22.46.198",8888);
            InetAddress inetAddress1 = socket.getInetAddress();
            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1.getHostAddress());

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名:admin;密码:123"+":"+inetAddress1.getHostName()+":"+inetAddress1.getHostAddress());
            printWriter.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info=null;
            while((info=bufferedReader.readLine())!=null){
                System.out.println("我是客服端.服务端说:"+info);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {

        }
    }
}
