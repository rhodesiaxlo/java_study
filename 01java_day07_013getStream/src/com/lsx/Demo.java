package com.lsx;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        // 集合
        // 流
        // oop 的概念还不是很熟

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, String> map = new HashMap<>();
        Set<String> set1 = map.keySet();
        Stream<String> stream3 = set1.stream();

        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();
        
        Stream<Integer> stream6 = Stream.of(1,2,3,4,5);
        
        Integer[] arr = {1,2,3,4,5,6};

        Stream<Integer> stream7 = Stream.of(arr);

        // stream 延迟方法 pipeline
        // 终结方法


    }

    @Test
    public void foreachTest() {

        Stream<String> steam = Stream.of("张三", "李四", "王五", "赵六", "田7");

        steam.forEach(s-> System.out.println(s));


    }

    @Test
    public void filterTest() {
        Stream<String> steam = Stream.of("张三", "张四", "王五", "赵六", "田7");
        steam.filter(s->s.contains("张")).forEach(s-> System.out.println(s));

    }

    @Test
    public void streamCloseTest() {
        Stream<String> steam = Stream.of("张三", "张四", "王五", "赵六", "田7");

        Stream<String> steam2 = steam.filter(s -> s.contains("张"));

        // 在此使用steam 报错
        steam.forEach(s-> System.out.println(s));


    }

    @Test
    public void mapTest() {
        Stream<String> stream1 = Stream.of("1", "2", "3");

        stream1.map(s->Integer.parseInt(s)).forEach(s-> System.out.println());

    }

    @Test
    public void countTest() {
        Stream<String> stream1 = Stream.of("1", "2", "3");
        System.out.println(stream1.count());
    }

    @Test
    public void limitTest() {
        Stream<String> stream1 = Stream.of("1", "2", "3","4", "5");
        stream1.limit(3).forEach(s-> System.out.println(s));

    }

    @Test
    public void skipTest() {
        Stream<String> stream1 = Stream.of("1", "2", "3","4", "5");
        stream1.skip(2).forEach(s-> System.out.println(s));
    }

    @Test
    public void concatTest() {
        Stream<String> stream1 = Stream.of("1", "2", "3","4", "5");
        Stream<String> stream2 = Stream.of("张飞", "关羽", "刘备");

        Stream.concat(stream1,stream2).forEach(s-> System.out.println(s));

    }

    @Test
    public void proTest() {
        ArrayList<String> lstOne = new ArrayList<>();
        lstOne.add("迪丽热巴");
        lstOne.add("宋远桥");
        lstOne.add("苏星河");
        lstOne.add("石破天");
        lstOne.add("石中玉");
        lstOne.add("老子");
        lstOne.add("孔子");
        lstOne.add("洪七公");

        ArrayList<String> lstTwo = new ArrayList<>();
        lstTwo.add("古力娜扎");
        lstTwo.add("张无忌");
        lstTwo.add("赵丽颖");
        lstTwo.add("张三丰");
        lstTwo.add("尼古拉斯赵思");
        lstTwo.add("张天爱");
        lstTwo.add("张二狗");

        Stream<String> stream1 = lstOne.stream().filter(s -> s.length() == 3).limit(3);
        Stream<String> stream2 = lstTwo.stream().filter(s -> s.contains("张")).skip(2);

        Stream.concat(stream1, stream2).map(s -> new Person(s)).forEach(s-> System.out.println(s));


    }


}
