package com.lsx;

public class DemoInterface {
    public static void main(String[] args) {

        // java 9 开始，接口里成员变量其实是常量
        //public static final 数据类型 数据名称

        // 接口中的方法都是抽象方法
        // [public] [abstract] 返回值 方法名称 参数列表

        // java 8 开始，可以有默认方法（！！！ 修改接口不用修改所有该接口的实现类

        // java8 开始，可以有静态方法
        // [public] [static] 返回类型 方法名称 参数列表 {方法体}

        // java9 开始，可以有私有方法
        // 普通私有方法  private 返回值 方法名称 参数列表 { 方法体 }
        // 静态私有方法  private static 返回值 方法名称 参数列表 { 方法体 }

        // 接口可以多继承
        // 接口不可以写静态代码块
        // 不能有构造方法


        Dog d1 = new Golden();
        d1.sound();
        d1.eat();
        d1.swim();
        d1.newBehaviour();

        // 原来接口增加一个新方法，所有实现该接口的实现类都必须重写，增加了default 后不需要

        // 静态方法举例
        // 只能是接口名称.
        Animal.staticMethod();

        //Animal

        // 接口继承接口
        // 如果多个父接口的抽象方法有重复，没有关系
        // 如果多个父接口的默认方法有重复，有关系，实现类或者接口必须重写 默认接口

        Fu f = new Fu();
        Zi z = new Zi();
        Fu fz = new Zi();

        // 测试1  成员变量，谁调用，用谁的
        System.out.println(f.name); // fu
        System.out.println(z.name); // zi
        System.out.println(fz.name); // fu

        System.out.println("============================");
        //测试2 重载方法 方法属于谁，调用谁
        f.method();  // fu
        z.method();  // zi
        fz.method();  // zi
        z.methodZi();  //zi

        // 测试3 重载方法中调用父类的变量或者局部变量
        // this  super


    }
}
