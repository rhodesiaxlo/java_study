package com.lsx;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class DemoProperties {
    public static void main(String[] args) throws IOException {
        // properties 是唯一一个和 io 集合
        // store
        // load
        // setproperty
        // string properties name

        Properties prop = new Properties();
        prop.setProperty("name", "lushixin");
        prop.setProperty("age", "20");
        prop.setProperty("gender", "男");

        //
        Set<String> strings = prop.stringPropertyNames();

        for (String string : strings) {
            System.out.println(" key name " + string + " value = " + prop.getProperty(string));
        }


        try(FileWriter fw = new FileWriter("o.txt");) {
            prop.store(fw, "12345");
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }


        // 加载
        // load 方法
        Properties prop1 = new Properties();
        prop1.load(new FileReader("o.txt"));

        System.out.println(prop1.stringPropertyNames().toString());


        // inputstream  中文不支持
        // reader 中文支持

        // outputstream 中文不支持
        // writer 中文支持



    }
}
