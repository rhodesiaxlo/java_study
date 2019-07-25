package com.lsx;

public class DemoFinal {

    public static void main(String[] args) {
        // 情况1
        // final 修饰类，不能被继承
        // final 不能和 abstract 在一起

        // 情况2
        // final 修饰方法，不能被重写

        // 情况3
        // final 修饰局部变量
        final int i;
        i = 200; // 正确
        //i = 200; // 错误
        //i = 300; // 错误

        // 情况4
        // final 修饰引用类型，不可以改变地址值，但是可以改变地址指向的对象的内容
        final Student s1 = new Student("高圆圆", 20);
        // s1 = new Student("赵又廷", 20);// 错误写法
        s1.setName("赵又廷");  // 正确


        // 情况5
        // final 修饰成员变量 必须手动赋值，这点和局部变量
        // 可以构造赋值或者手动赋值


    }
}
