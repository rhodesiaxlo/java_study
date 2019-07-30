package com.lsx;

import sun.security.util.Length;

import java.io.*;
import java.nio.Buffer;

public class Demo {

    public static void main(String[] args) {
        // 通过赋值文件，比较 单字节赋值
        // 字节数组赋值
        // 字节缓冲输出流，来比较赋值效率

        copyFile("667.txt", "file.txt");
        copyFileBatch("667.txt", "batch.txt", 1024);
        bufferedCopyFile("667.txt", "buffer.txt");
    }


    public static void copyFile(String src, String dest){
        long l = 0;
        try(
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);){
            l = System.currentTimeMillis();
            int tmp = -1;
            while((tmp=fis.read())!=-1) {
                fos.write(tmp);
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        System.out.println("fileinputstream : " + (System.currentTimeMillis() - l));

    }


    public static void copyFileBatch(String src, String dest, int size){
        long l = 0;
        try(
                FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dest);){
            l = System.currentTimeMillis();
            int tmp = -1;
            byte[] list = new byte[size];
            while((tmp=fis.read(list))!=-1) {
                fos.write(list, 0, tmp);
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        System.out.println("fileinputstream in batch : " + (System.currentTimeMillis() - l));

    }

    public static void bufferedCopyFile(String src , String dest) {
        long l = 0;

        try(
        FileInputStream fios = new FileInputStream(src);
        BufferedInputStream bis = new BufferedInputStream(fios);
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bos = new BufferedOutputStream(fos);) {
            l = System.currentTimeMillis();

            byte[] list = new byte[1024];
            int len = 0;
            while((len = bis.read(list))!=-1) {
                bos.write(list, 0, len);
            }


        } catch(Exception e) {
            System.out.println(e);
        }

        System.out.println("buffered  : " + (System.currentTimeMillis() - l));

    }




}
