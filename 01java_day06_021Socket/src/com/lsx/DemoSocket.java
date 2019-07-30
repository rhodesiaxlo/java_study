package com.lsx;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class DemoSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8999);
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("你好".getBytes("utf-8"));

        outputStream.close();
        socket.close();
    }

}
