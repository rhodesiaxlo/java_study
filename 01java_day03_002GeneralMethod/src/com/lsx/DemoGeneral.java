package com.lsx;

import com.lsx.impl.GeneralManager;
import com.lsx.impl.GeneralManager2;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoGeneral {
    public static void main(String[] args) {
        GeneralMethodManager m = new GeneralMethodManager();
        m.generalMethod(1);
        m.generalMethod(true);
        m.generalMethod("hello world");

        // 接口使用泛型的第一种方式
        GeneralManager m2 = new GeneralManager();
        m2.method("1234");

        // 接口使用泛型的第二种方式
        GeneralManager2<Boolean> m3 = new GeneralManager2<>();
        m3.method(true);

        // 通配符
        ArrayList<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        ls1.add(2);
        ls1.add(3);

        ArrayList<String> ls2 = new ArrayList<>();
        ls2.add("aaaa");
        ls2.add("bbbb");
        ls2.add("cccc");

        iterMethod(ls1);
        iterMethod(ls2);

        // 受限泛型
        // extend
        // super

    }

    /**
     * 遍历集合，但是不知道数据类型
     */
    public static void iterMethod(ArrayList<?> list)
    {
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
