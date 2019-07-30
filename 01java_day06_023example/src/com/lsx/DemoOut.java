package com.lsx;

import java.io.FileOutputStream;

public class DemoOut {
    public static void main(String[] args) {
        // 输入文件会写入 -1 ma
        try(
        FileOutputStream fos = new FileOutputStream("out.txt");) {

            //
            fos.write(97);
            fos.write(98);
            fos.write(99);
            fos.write(100);

        } catch (Exception e) {

        }


    }
}
