package com.lsx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class DemoSort {
    public static void main(String[] args) {
        // 文章排序
        HashMap<String, String> map = new HashMap<>();
        try(
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("out.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        ) {
            //
            String tmp = null;
            while((tmp = br.readLine())!=null) {
                String[] arr = tmp.split("\\.");
                map.put(arr[0], arr[1]);
            }


            // 排序，输入
            for (String s : map.keySet()) {
                String value = map.get(s);
                // 字符输入流不包含任何结束标记
                String line = s + "." +value;
                bw.write(line);
                bw.newLine();
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
