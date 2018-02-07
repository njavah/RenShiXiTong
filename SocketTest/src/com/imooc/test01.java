package com.imooc;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class test01 {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名:"+inetAddress.getHostName());
            System.out.println("IP地址:"+inetAddress.getHostAddress());
            byte[] bytes = inetAddress.getAddress();
            System.out.println("字节数组内容:"+ Arrays.toString(bytes));
            //InetAddress inetAddress1 = InetAddress.getByName("DESKTOP-GR6R9U3");
            InetAddress inetAddress1 = InetAddress.getByName("172.22.17.170");
            System.out.println("计算机名:"+inetAddress1.getHostName());
            System.out.println("IP地址:"+inetAddress1.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
