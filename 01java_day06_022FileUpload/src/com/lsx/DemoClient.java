package com.lsx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DemoClient {

    public static void main(String[] args) {

        // 如果不调用 socket.shutdownoutputstream
        // 程序会阻塞，为什么？？？？？？？？？？？？？？
//        ？？？？？？？？？？？？？？？？？？？？？？？？？
//        ？？？？？？？？？？？？？？？？？？？？？？？？？、?\\
//        ????????????????????????????????????????????

        try(
                Socket socket  = new Socket("127.0.0.1", 9000);

                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();

                FileInputStream fis = new FileInputStream("in.png");
        ) {
            int len;
            byte[] buffer = new byte[1024];

            while ((len = fis.read(buffer)) != -1) {
                // 读取写入outputstream
                os.write(buffer, 0, len);
            }

            socket.shutdownOutput();

            while((len=is.read(buffer))!=-1) {
                System.out.println("服务器返回" + new String(buffer, 0, len));
            }

        }catch(Exception e) {

        }

    }
}
