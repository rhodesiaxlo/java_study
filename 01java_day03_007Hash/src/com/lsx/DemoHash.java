package com.lsx;

import java.util.HashSet;

public class DemoHash {

    public static void main(String[] args) {
        String s1 = "1234";


        // 引用类型不同，hash值可以相同
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());

        // 相同的对象hash 值一定是相同的
        Person p1 = new Person("张三", 10);
        Person p2 = new Person("张三", 10);
        Person p3 = new Person("张三", 20);

        System.out.println(" p1 :" + p1.hashCode());
        System.out.println("修改p1 对象");
        p1.setAge(50);
        System.out.println(" p1 :" + p1.hashCode());
        System.out.println(" p2 :" + p2.hashCode());
        System.out.println(" p3 :" + p3.hashCode());

        String s2 = "12345678";
        String s3 = "12345678";
        String s4 = "89999999";
        String s5 = "44444444";
        System.out.println("s2" + s2.hashCode());
        System.out.println("s3" + s3.hashCode());
        System.out.println("s4" + s4.hashCode());
        System.out.println("s5" + s5.hashCode());

        // set 中判定元素重复的方法
        // hash值判定  equals 判定

        HashSet<Person> os = new HashSet<>();
        os.add(new Person("小美女", 20));
        os.add(new Person("小美女", 20));
        os.add(new Person("小美女", 10));

        System.out.println(os);
        // [Person{name='小美女', age=20}, Person{name='小美女', age=20}, Person{name='小美女', age=10}]

        // 重写hash code 和 equal 后，重复内容的对象只存储一次了，这样就可以使用hashset进行存储自定义的对象了
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Person person = (Person) o;
//            return Objects.equals(name, person.name) &&
//                    Objects.equals(age, person.age);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name, age);
//        }



    }
}
