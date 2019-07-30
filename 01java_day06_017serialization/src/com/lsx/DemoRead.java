package com.lsx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoRead {
    public static void main(String[] args) {
        try(
                ObjectInputStream oit = new ObjectInputStream(new FileInputStream("o.txt"));
        ) {

            // 必须要重写一个方法读取二进制文件，否则 静态成员变量 static integer age 还是返回的20，这是 jvm 的缘故，而不是说
            // 静态成员变量可以序列化
            Person p2 = (Person)oit.readObject();
            System.out.println(p2);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
