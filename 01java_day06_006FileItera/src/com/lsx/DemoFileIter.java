package com.lsx;


import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class DemoFileIter {

    class FileFilter1 extends FileFilter {
        @Override
        public boolean accept(File f) {
            if(f.isFile())
                return true;

            return false;
        }

        @Override
        public String getDescription() {
            return null;
        }
    }
    public static void main(String[] args) {
        // 文件遍历示例

        File root = new File("F:\\vbshare\\java_study\\01java_day06_006FileItera");
        System.out.println("根路径" + root.getAbsolutePath());
        readFile(root, 0);


    }

    class DirFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            return f.isDirectory();
        }

        @Override
        public String getDescription() {
            return null;
        }
    }


    public static void readFile(File path, Integer level) {
        if(!path.exists()) {
            return;
        }

        // 获取文件
        File[] flist = path.listFiles((f)->f.isFile());
        File[] dlist = path.listFiles((f)->f.isDirectory());


//        path.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                System.out.println("dir = " + dir + " name= " + name);
//                return false;
//            }
//        });


        // 打印文件，递归文件夹

        for (File file : flist) {
            indent(level);
            System.out.println(file.getName());
        }

        for (File file : dlist) {
            indent(level);
            System.out.println(file.getName()+"/");
            readFile(file, level+1);

        }

        //return null;

    }

    public static void indent(Integer level) {
        for (int i = 0; i < level+1; i++) {
            System.out.print("  ");
        }
    }
}
