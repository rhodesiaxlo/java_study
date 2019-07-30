package com.lsx;

import java.io.PrintStream;

public class DemoPrintSteam {
    public static void main(String[] args) {
        //printstream
        // 1. 只负责数据的输出，不负责数据的读取
        // 2. 不会抛出ioexception
        // 3. 有特有的方法 print println

        try(
        PrintStream ps = new PrintStream("in.txt");
        ) {
            ps.write('a');
            ps.write('b');
            ps.write('c');
            ps.write('d');
        } catch(Exception e) {
            System.out.println(e);
        }

        // 设置输出目的地
        //System.setOut();


    }
}
