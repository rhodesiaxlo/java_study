package com.lsx;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;

public class DemoOutputstream {
    public static void main(String[] args) throws IOException {
        // inputstream
        // outputstream  byteoutputstream fileoutputstream fileteroutputstream objectoutputstream pipeoutputstream
        // inputstream

        /*  公用方法
         outputstream
         close()
         write() write(byte[])
        */

        /*
        * fileoutputstream 使用示例
        * 数据的追加和换行
        * */


        //FileOutputStream fos = new FileOutputStream("1.txt", true);

        // 文件字节输出列没有flush
        //fos.write(97);
//        fos.write("this is a test text\n".getBytes());
//        fos.close();
//
//        System.out.println(Integer.valueOf('\n'));
//        System.out.println(Integer.valueOf('\r'));
//        System.out.println(Integer.valueOf(' '));


        /*
        * inputstream
        * available
        * close
        * mark
        * marksupported
        * read
        * read
        * reset
        *
        * */

        FileInputStream fio = new FileInputStream("1.txt");
        int read = -1;
        byte[] lst = new byte[2];
        while ((read = fio.read(lst))!=-1) {
            System.out.println("read = " + read);
            System.out.println(new String(lst));
        }

        //copy(new File("1.txt"));

        // gbk 2 个字节
        // utf-8 3 个字节



    }

    public static void copy(File file) throws IOException {
        String src = file.getName();
        String[] list  = src.split("\\.");
        String target = "new." + list[list.length-1];

        FileOutputStream fos = new FileOutputStream(target);

        FileInputStream fis = new FileInputStream(file);

        int ch = -1;
        while((ch=fis.read())!=-1) {
            fos.write(ch);
        }

        fis.close();
        fos.close();

    }
}
