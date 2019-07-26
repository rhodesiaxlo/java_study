package com.lsx;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.HashMap;
import java.util.Scanner;

public class DemoCharCount {

    public static void main(String[] args) {
        // 捕获用户输入
        System.out.println(" 请属于一个字符串。。。");

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        // 分解输入，计算字符个数
        char[] chars = line.toCharArray();
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char aChar : chars) {
            if(charCount.containsKey(aChar))
            {
                // 存在
                charCount.put(aChar, charCount.get(aChar) + 1);
            } else {
                // 不存在
                charCount.put(aChar, 1);
            }
        }

        // 输入统计结果
        System.out.println(charCount);


        // jdk 9 的新特性
        // list set map

    }
}
