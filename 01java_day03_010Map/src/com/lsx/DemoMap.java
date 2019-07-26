package com.lsx;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        // hashmap 无序
        // linkedhashmap 有序

        // 添加
        // 查询
        // 删除

        HashMap<String, Integer> h1 = new HashMap<>();

        h1.put("a", 1);
        h1.put("a", 2);
        h1.put("a", 3);
        h1.put("a", 4);

        // put 用法，如果key 不存在返回null， 否则返回替换前的value
        System.out.println(h1);

        System.out.println(h1.keySet());

        System.out.println("remove a " + h1.remove("a"));
        System.out.println(h1);

        // 获取
        h1.put("abc", 123);
        h1.put("a", 1);
        h1.put("b", 2);
        h1.put("c", 3);
        h1.put("d", 4);
        h1.put("e", 5);
        h1.put(null, 6);
        h1.put(null, null);

        System.out.println("abc 的值是" + h1.get("abc"));

        System.out.println(" h1 中是否包含值 123"+ h1.containsValue(123));
        System.out.println(" h1 中是否包含值 1234"+ h1.containsValue(1234));
        System.out.println(" h1 中是否包含键 abc"+ h1.containsValue("abc"));
        System.out.println(" h1 中是否包含键 abcd"+ h1.containsValue("abcd"));

        // 遍历集合
        for (String s : h1.keySet()) {
            System.out.print(h1.get(s) + " , ") ;
        }

        // entryset 遍历集合
        // entry.getkey entry.getvalue

        System.out.println("=======================================================");
        Iterator<Map.Entry<String, Integer>> iterator = h1.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "," +next.getValue());
        }

        System.out.println("=======================================================");

        // hashtable  线程安全  不能存取  null
        // vector   iterator
        // hashtable properties


    }
}
