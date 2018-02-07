package com.imooc;

import java.io.*;
import java.net.Socket;

public class servicethread extends  Thread {
    Socket socket = null;
    public servicethread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        InputStream  inputStream = null;
        InputStreamReader inputStreamReader= null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream= null;
        PrintWriter printWriter = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info=null;
            while((info=bufferedReader.readLine())!=null){
                System.out.println("我是服务端.客服端说:"+info);
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎你");
            printWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                printWriter.close();
                outputStream.close();
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
