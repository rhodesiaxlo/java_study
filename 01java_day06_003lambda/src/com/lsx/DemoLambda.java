package com.lsx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        // 可以不要参数类型神明
        // 可以省略 return
        Collections.sort(list, (o1, o2)->o1-o2);
        System.out.println(list);
    }
}
