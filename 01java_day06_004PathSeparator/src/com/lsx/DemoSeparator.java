package com.lsx;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class DemoSeparator {
    public static void main(String[] args) throws IOException {
        // path separator
        System.out.println("路径分隔符" + File.pathSeparator);
        // 路径分隔符， linux 和  window 不一样

        System.out.println("文件路径分隔符 " + File.separator);
        // 文件路径分隔符，windows 和linux也不太一样

        System.out.println("separator " + File.separator);

        System.out.println("separator char " + File.separatorChar);

        File f = new File("F:\\11.txt");
        System.out.println("file exists " + f.exists());
        System.out.println("is directory " + f.isDirectory());

        System.out.println("getpath " + f.getPath());
        System.out.println("getname " + f.getName());
        System.out.println("getparent " + f.getParent());

        System.out.println("can write : "+ f.canWrite());
        System.out.println("can read : "+ f.canRead());
        System.out.println("can execute : "+ f.canExecute());

        System.out.println("get absolute file " + f.getAbsoluteFile());
        System.out.println("get absolute path " + f.getAbsolutePath());

        // rename mkdir
        //System.out.println(" rename " + f.renameTo(new File("F:\\11.txt")));
        System.out.println("file length" + f.length());

        System.out.println("list files " + f.listFiles());

        //
        File f2 = new File("F:\\");

        System.out.println(" director f:\\ is directory "+ f2.isDirectory());
        System.out.println(" files under f:\\ is " + Arrays.toString(f2.listFiles()));


        System.out.println("get absolute file " + f2.getAbsoluteFile());
        System.out.println("get absolute path " + f2.getAbsolutePath());

        System.out.println("get can path " + f2.getCanonicalPath());

        // get

        // 判断属性

        // set
        // System.out.println("删除文件" + f.delete());

        File f3 = new File("F:\\testdir");
        System.out.println("创建文件夹" + f3.mkdir());



    }
}
