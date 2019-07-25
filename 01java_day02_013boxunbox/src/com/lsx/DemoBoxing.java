package com.lsx;

public class DemoBoxing {
    public static void main(String[] args) {
        // box
        Integer i1 = new Integer("10");
        Integer i2 = new Integer(10);
        //Integer i3 = new Integer("abc");

        System.out.println("i1 = " +i1);
        System.out.println("i2 = " +i2);
        //System.out.println("i3 = " +i3);
        
        //unbox
        int i = i1.intValue();
        String s = i1.toString();
        long l = i1.longValue();

        // jdk 1.5 之后自动装箱
        Integer i4 = 10;
        i4 = i4 + 10; // 自动拆箱，完成计算后，自动装箱

        // 基本类型和字符串的转换
        // 方法1 + ""
        // 方法2 String.toString()
        // String.valueOf();

        // 字符串转基本类型
        // 包装类 parse
    }
}
