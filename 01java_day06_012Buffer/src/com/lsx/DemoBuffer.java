package com.lsx;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemoBuffer {

    public static void main(String[] args) {
        // bufferinputstream
        // bufferoutpustream
        try(FileOutputStream fos = new FileOutputStream("o.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);) {

            //
            bos.write("这是一条测试信息\r\n".getBytes());
            bos.write("这是第二条测试信息\r\n".getBytes());
            bos.flush();

        } catch(IOException e) {

        }




    }
}
