package com.lsx;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DemoStream {
    public static void main(String[] args) {
        //
        // 获取流的2中方式
        // collection.stream
        // stream.valueof()

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("张飞");

        list.stream().filter(s -> s.contains("张"))
                     .filter(s -> s.contains("飞")).findFirst();


    }
}
