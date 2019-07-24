package com.lsx;

import sun.security.util.ArrayUtil;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {

        System.out.println(" string 类练习");
        // 操作
        // 数据长度
        // 是否是空字符串
        // 字符串是否相等

        // 截取字符串
        // 字符串是常量
        //

        String str = "1234";
        System.out.println(str.length());
        System.out.println(" str 是否是空 " + str.isEmpty());
        System.out.println(" str 是否和 123 相等" + "123".equals(str));



        // contains
        // endwith
        // start with


        // ignore ccase

        // replace
        // match ????

        // 字符串常量一旦创建，用不可变
        String abc = "12345";
        String bbc = "12345";
        char[] charArr = {'1','2','3','4','5'};
        String cbc = new String(charArr);
        System.out.println(" abc = " + abc);
        System.out.println(" bbc = " + bbc);
        System.out.println("abc == cbc " + (abc == cbc));
        System.out.println("bbc == cbc " + (bbc == cbc));
        System.out.println("abc == bbc " + (abc == bbc));
        // 所以说，对于基本类型，== 比较的是值
        // 对于引用类型 比较的是地址值
        System.out.println("abc equals cbc " + (abc.equals(cbc)));
        System.out.println("abc equals cbc " + (abc.equals(cbc)));
        System.out.println("abc equals cbc " + (abc.equals(cbc)));


        System.out.println("a " + (1+'a'));
        System.out.println("A " + (1+'A'));
        String a = "abc";
        String a2 = "Abc";
        String a3 = "acc";
        System.out.println(" a > a2 " +a.compareTo(a2));
        System.out.println(" a > a3 " +a.compareTo(a3));
        System.out.println(" a2 > a3 " +a2.compareTo(a3));

        // 截取
        String sub1 = "abcdefghijk";

        System.out.println(sub1.substring(1));
        System.out.println(sub1.substring(1,2));// 左闭右开

        System.out.println(sub1.replace("abcdefg","1"));

        // split 的参数是一个正则表达式，不能直接使用.
        String splt = " hello world ";
        String[] ll = splt.split(" ");
        System.out.println(ll.length);
        String splt1 = "hello.world";
        String[] ll2 = splt1.split("."); //错误写法
        System.out.println(" 错误写法示例，切分不出来" + ll2.length);
        String[] ll3 = splt1.split("\\.");
        System.out.println(Arrays.toString(ll3));


        // 重名的问题
        // !!!!!!!!!!!!!!
        // 调用相同的成员变量，谁条用用谁的变量
        Zi z = new Zi();
        System.out.println(z.var1);

        Fu f = new Fu();
        System.out.println(f.var1);

        // 方法，用谁的方法，用谁的变量
        z.methodZi();
        z.methodFu();

        // this
        // super


        // 3 种 情况 父子中 同名变量
        // 调用同名变量的不同方法
        // 相同方法




    }
}
