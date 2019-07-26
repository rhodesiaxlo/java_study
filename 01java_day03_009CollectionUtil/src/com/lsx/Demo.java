package com.lsx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();

        Collections.addAll(l1, "1","2","33","4","100","99","98");
        System.out.println("初始化" + l1);

        // 默认升序排列
        Collections.sort(l1);
        System.out.println("排序后" + l1);

        Collections.sort(l1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i1 = Integer.parseInt(o1);
                Integer i2 = Integer.parseInt(o2);
                return i1-i2;
            }
        });
        System.out.println(l1);


        // 自定义对象
        List<Person> l2 = new ArrayList<>();
        Collections.addAll(l2, new Person("张三", 100), new Person("李四", 50), new Person("王五",200));
        System.out.println("初始化的 l2 " + l2);
        // 没有实现 comparable ,不能排序
        Collections.sort(l2);
        System.out.println(l2);



    }
}
