package com.lsx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerUpload {
    public static void main(String[] args) throws IOException {
        // 服务器上传文件示例

        // 客户端 使用 Inputstream 读取文件
        // 使用 网络字节输出流，上传到服务器
        // 服务器使用网络字节输入流，读取客户上传的文件，
        // 服务器使用 output 输入流 保存到本地
        // 服务器回显接收状态
        // 客户端接收状态

        try(
        ServerSocket serverSocket = new ServerSocket(9000);

        // 获取客户端对象
        Socket cli = serverSocket.accept();

        // 根据客户端对象获取 io 流
        InputStream is = cli.getInputStream();
        FileOutputStream fos = new FileOutputStream("out.png");

        OutputStream os = cli.getOutputStream();
        ) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            os.write("success".getBytes("utf-8"));
            System.out.println("success");
        }catch(Exception e) {

        }

    }
}
