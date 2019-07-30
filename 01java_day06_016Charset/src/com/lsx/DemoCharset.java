package com.lsx;

import java.io.*;
import java.nio.charset.Charset;

public class DemoCharset {

    public static void main(String[] args) {
        //
        //InputStream
        //outputstream
        //fileinputstream
        //fileoutputstream
        //reader
        //writer
        //filereader
        //filewriter
        //bufferfilereader
        //bfferwriter



        //fiileinputreader
        //fileoutputwriter

        try(
        FileInputStream fis = new FileInputStream("gbk.txt");
        InputStreamReader fsr = new InputStreamReader(fis, "gbk");
        FileOutputStream fos = new FileOutputStream("utf.txt");
        OutputStreamWriter ow = new OutputStreamWriter(fos, "utf-8");
        ) {

            //
            char[] buffer =new char[1024];
            while(fsr.read(buffer)!=-1) {
                System.out.println(new String(buffer));
                ow.write(new String(buffer));
            }

        } catch(Exception e) {
            System.out.println(e);
        }


    }
}
