package com.imooc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpclient {
    public static void main(String[] args) throws  Exception {
        //想要发送的数据
        byte[] bytes = "用户名:admin;密码:123".getBytes();
        //服务段的地址
        InetAddress inetAddress = InetAddress.getByName("localhost");
        //服务端的端口号
        int port = 8800;
        //创建数据包，给服务端发送数据
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,inetAddress,port);
        //创建socket
        DatagramSocket socket = new DatagramSocket();
        //给服务端发送数据
        socket.send(packet);

        byte[] bytes1 = new byte[1024];
        //创建接受服务端的数据包
        DatagramPacket packet1 = new DatagramPacket(bytes1,bytes1.length);
        //接受服务端的数据
        socket.receive(packet1);
        //读出数据
        String s = new String(bytes1,0,bytes1.length);
        System.out.println("我是客服端。服务端说:"+s);
        socket.close();
    }
}
