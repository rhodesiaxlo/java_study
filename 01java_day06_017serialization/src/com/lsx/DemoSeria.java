package com.lsx;

import java.io.*;

public class DemoSeria {
    public static void main(String[] args) {

        try(
        ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("o.txt"));
        ) {
            Person p = new Person("bbb", 20);
            oot.writeObject(p);

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
