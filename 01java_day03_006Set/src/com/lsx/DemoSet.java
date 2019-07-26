package com.lsx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DemoSet {

    public static void main(String[] args) {

        Set<String> ss = new HashSet<>();

        ss.add("a");
        ss.add("a");
        ss.add("b");
        ss.add("c");
        ss.add("d");
        ss.add("e");
        ss.add("f");
        ss.add("g");
        ss.add("h");

        ss.add("String1");
        ss.add("String5");
        ss.add("String4");
        ss.add("String2");
        ss.add("String3");

        // 遍历

        // for循环遍历// 没有索引，所以不支持

        // 增强 for 循环
        System.out.println("增强 for 循环遍历");
        for (String s : ss) {
            System.out.print(s + " ," ) ;
        }
        System.out.println();

        // 迭代器循环
        System.out.println("迭代器 遍历");
        Iterator<String> iterator = ss.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ," );
        }

        int i = 100;

        System.out.println("=======================");
        while(i>0) {
            System.out.print(" 遍历" + i + "   " );
            iterator = ss.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ," );
            }

            System.out.println();

            i--;
        }

    }
}
