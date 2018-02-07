package com.imooc;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class test02 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.imooc.com");
            System.out.println("协议:"+url.getProtocol());
            System.out.println("主机:"+url.getHost());
            System.out.println("端口号:"+url.getPort());
            System.out.println("文件路径:"+url.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
