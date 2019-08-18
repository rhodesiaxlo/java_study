package com.lsx;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BerTest {


    @Test
    public  void CoffTest() {
        Coff co = new Coff();
        co.prepare();
    }

    @Test
    public  void scanTest() {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(s);
        }
    }

    /**
     * 模板方法的其他举例  comparator
     */
    @Test
    public  void BufferTest() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }
}
