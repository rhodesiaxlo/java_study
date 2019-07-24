package com.lsx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // 数组的长度一旦定义，就不能修改，为了突破这个限制，我们推出 arrayList
        // 泛型只能是引用类型，不能是基本类型


        // isEmpty
        // size

        // add
        // add(insert)
        // get
        // remove
        // removerange
        //set
        //clear


        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("成龙", 50));
        list.add(new Person("我", 20));
        list.add(new Person("习近平", 60));

        System.out.println(list);

        //  泛型不能代表基本类型
        // ArrayList<int> list2 = new ArrayList<int>();

        // 练习，生成 6 个随机1-33 的整数，放入集合, 然后遍历集合
        System.out.println("练习1，生成 6 个随机1-33 的整数，放入集合, 然后遍历集合");
        Random r = new Random();
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0;
        while(i<6)
        {
            // 生成正整数 放入集合
            list3.add(r.nextInt(33) + 1);
            i++;
        }

        for (Integer integer : list3) {
            System.out.println(integer);
        }

        System.out.println("=============== 另外一种遍历形式");
        for (int i1 = 0; i1 < list3.size(); i1++) {
            // 取数据  get
            System.out.println(list3.get(i1));
        }

        // 练习2， 自定义4个学生对象，添加到 arraylist并遍历
        System.out.println(" 练习2， 自定义4个学生对象，添加到 arraylist并遍历");
        int j = 0;
        ArrayList<Person> list4 = new ArrayList<>();
        while(j< 4)
        {
            // 添加学生对象
            list4.add(new Person(((Integer)j).toString(), j));
            j++;
        }

        for (int i1 = 0; i1 < list4.size(); i1++) {
            System.out.println(list4.get(i1));
        }


        System.out.println("!!!!!!!!!!!!!!");
        System.out.println(" 练习3 遍历筛选");
        ArrayList<Integer> list5 = new ArrayList<>();
        int k = 0;
        while(k<15)
        {
            list5.add(r.nextInt(100));
            k++;
        }

        System.out.println(list5);
        // 遍历
        Iterator<Integer> iterator = list5.iterator();
        while(iterator.hasNext())
        {
            Integer tmp = iterator.next();
            if(tmp<50)
                iterator.remove();
        }

        System.out.println(list5);


    }
}
