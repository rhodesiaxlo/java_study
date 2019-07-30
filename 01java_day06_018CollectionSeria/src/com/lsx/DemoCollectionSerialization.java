package com.lsx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DemoCollectionSerialization {

    public static void main(String[] args) {
        //
        try(
                ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("in.txt"));
        ) {

            List<Person> list = new ArrayList<>();
            list.add(new Person("鲁仕鑫", 31));
            list.add(new Person("柠檬", 31));
            list.add(new Person("黄飞鸿", 31));

            ois.writeObject(list);
        } catch (Exception e) {

        }

    }
}
