package com.lsx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadSeria {
    public static void main(String[] args) {
        try(
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("in.txt"));
        ) {



            ArrayList<Person> list = (ArrayList<Person>)ois.readObject();
            for (Person person : list) {
                System.out.println(person);
            }
        } catch (Exception e) {

        }
    }
}
