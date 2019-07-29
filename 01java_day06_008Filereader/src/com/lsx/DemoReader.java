package com.lsx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketTimeoutException;

public class DemoReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src\\1.txt");

        char[] cs = new char[10];
        int len = 0;
        while((len=fr.read(cs))!=-1) {
            System.out.println("有效字符数" + len + " " + new java.lang.String(cs,0, len));
        }
    }
}
