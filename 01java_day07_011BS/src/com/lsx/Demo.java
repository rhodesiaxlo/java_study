package com.lsx;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    public static void main(String[] args) throws IOException {

            // 这个示例还没有结束，需要增加多线程，线程池技术
            // 多路复用
            //
            //
            //

            ServerSocket serverSocket = new ServerSocket(9000);


            while(true) {

                // 多线程
                // 线程池技术


                // 获取客户端对象
                Socket cli = serverSocket.accept();

                // 根据客户端对象获取 io 流
                InputStream is = cli.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                OutputStream os = cli.getOutputStream();

                int len;
                byte[] buffer = new byte[1024];
                int i = 0;
                String[] s = br.readLine().split(" ");
                String filename = s[1];

                filename = filename.substring(1);
                System.out.println(filename);


                // 报文格式
                // ???????!!!!!!
                FileInputStream fileInputStream = new FileInputStream("src/" +filename);
                os.write("HTTP/1.1 200k\r\n".getBytes("utf-8"));
                os.write("Content-Type:text/html\r\n".getBytes("utf-8"));
                os.write("\r\n".getBytes("utf-8"));

                int len1 = 0;
                byte[] buf = new byte[1024];
                while ((len1=fileInputStream.read(buf))!=-1) {
                    os.write(buf,0, len1);
                }

                fileInputStream.close();
                cli.close();
                os.close();
            }






//            GET / HTTP/1.1
//            Host: 127.0.0.1:9000
//            Connection: keep-alive
//            Cache-Control: max-age=0
//            Upgrade-Insecure-Requests: 1
//            User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36
//            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
//            Accept-Encoding: gzip, deflate, br
//            Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
    }
}
