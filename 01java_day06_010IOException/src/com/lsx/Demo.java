package com.lsx;

import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        try(
                FileWriter fr = new FileWriter("out.txt");
                ) {

            fr.write("hello world");


        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
