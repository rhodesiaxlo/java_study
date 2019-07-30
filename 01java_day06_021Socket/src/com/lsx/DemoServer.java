package com.lsx;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class DemoServer {

    public static void main(String[] args) {

        try(
        ServerSocket serversocket = new ServerSocket(8999);



        Socket accept = serversocket.accept();

        // 获取socket 的io流
        InputStream inputStream = accept.getInputStream();
        ) {
            System.out.println("等待连接...");



            byte[] buffer = new byte[1024];
            int len;

            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len, "utf-8"));
            }

            System.out.println(" get message from clicent: " + sb);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
