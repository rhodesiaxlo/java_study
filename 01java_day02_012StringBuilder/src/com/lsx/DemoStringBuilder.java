package com.lsx;


public class DemoStringBuilder {
    public static void main(String[] args) {
        String abc = "12345";
        StringBuilder sb = new StringBuilder(abc);
        System.out.println(sb.reverse());

        StringBuilder sb1 = new StringBuilder();
        System.out.println("空参构造" + sb1);
        System.out.println("append 后" + sb1);



    }
}
