package com.lsx;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class DemoWriter {

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("out2.txt");
        fw.write("这是一条测试信息\n");
        fw.append("这有是一条测试信息\n");

        fw.close();

    }
}
