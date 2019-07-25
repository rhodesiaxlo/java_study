package com.lsx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DemoCollection {

    public static void main(String[] args) {

        // collection 框架，以后学习的原则都是顶层学习开始
        // collection
        // list {有序，有索引，可以重复} set{无须，没有索引，不可重复}
        // vector arrayList LinkedList       treeset hashset
        //                                       linked hashset



        // 公有方法
        // isEmpty
        // size
        // clear
        // add
        //
        // remove

        // contains
        // toArray

        //示例1 多态
        Collection<String> l1 = new ArrayList<>();
        l1.add("张三");
        l1.add("李四");
        l1.add("王五");
        l1.add("田七");
        System.out.println(l1);

        // 示例2 迭代器示例
        Iterator<String> iter = l1.iterator();
        while(iter.hasNext())
        {
            String tmp = iter.next();
            if(tmp.equals("张三"))
            {
                iter.remove();
            }
        }

        System.out.println("删除之后" + l1);
    }
}
