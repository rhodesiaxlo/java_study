package com.lsx;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.java2d.pipe.SpanIterator;

import java.io.FileInputStream;

public class DemoRead {
    public static void main(String[] args) {
        try(
        FileInputStream fis = new FileInputStream("out.txt");
        ) {

            System.out.println("xxxxx");
            int tmp = 0;
            while((tmp=fis.read())!=-1) {
                System.out.println(tmp);
            }
            System.out.println(tmp);
            System.out.println("success");
        } catch (Exception e) {

        }
    }
}
