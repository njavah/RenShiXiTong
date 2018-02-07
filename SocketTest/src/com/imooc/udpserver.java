package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udpserver {
    public static void main(String[] args) {
        try {
            //创建socket
            DatagramSocket socket = new DatagramSocket(8800);
            //创建数据包接受数据
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
            //接受数据包
            System.out.println("服务器即将启动，等待客服端的链接");
            socket.receive(packet);
            //获取接受的数据
            String info = new String(bytes,0,packet.getLength());
            System.out.println("我是服务端。客服端说:"+info);

            //得到客服端的地址
            InetAddress inetAddress = packet.getAddress();
            //得到端口号
            int port = packet.getPort();
            //想要回复客户端的数据
            byte[] bytes1 = "欢迎你".getBytes();
            //创建回复客户端的数据包
            DatagramPacket packet1 = new DatagramPacket(bytes1,bytes1.length,inetAddress,port);
            //发送数据
            socket.send(packet1);

            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
