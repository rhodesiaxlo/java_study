package com.lsx;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DemoBufferInputstream {
    public static void main(String[] args) {
        try(
        FileInputStream fis = new FileInputStream("1.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        ) {
            //
            byte[] list = new byte[10];
            int len = 0;
            while ((len = bis.read(list))!=-1) {
                System.out.println(new String(list, 0, len));
            }

        } catch(IOException e) {

        }

    }
}
