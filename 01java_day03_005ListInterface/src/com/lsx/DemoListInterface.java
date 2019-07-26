package com.lsx;

import java.util.LinkedList;
import java.util.List;

public class DemoListInterface {
    public static void main(String[] args) {
        //

        LinkedList<String> ll = new LinkedList<>();

        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");

        // 添加
        ll.addFirst("0");;

        System.out.println(ll);

        // 删除
        ll.pop();
        System.out.println(ll);

        // 查找
        System.out.println("index of a is "  + ll.indexOf("a"));

        // 获取
        System.out.println(" ll 第2个元素是 " + ll.get(2-1));

        // 多态
        List<String> ll2 = new LinkedList<>();
        // 接口有的，类特有的
        // ll2.add()
        // ll2.get()
        // ll2.isEmpty()

        // linked list 特有的
        LinkedList<String> ll3 = (LinkedList<String>) ll2;
        ll3.pop();

        // vector 是单线程的，同步的



    }
}
