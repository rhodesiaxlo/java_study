package com.lsx;

public class DemoAnonyClass {

    public static void main(String[] args) {

        IMyInterface some = new IMyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类的method 方法执行了。。。");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类的 method2 方法执行了 。。。");
            }
        };

        // 匿名内部类，但不是匿名对象
        some.method();
        some.method();
        some.method2();

        new IMyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类 也是匿名对象的 method 执行了...");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类，也是匿名对象的 method2 执行了... ");
            }
        }.method();
    }
}
