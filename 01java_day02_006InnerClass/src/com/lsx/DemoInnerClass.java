package com.lsx;

public class DemoInnerClass {

    public static void main(String[] args) {

        // 调用方式1
        Body b = new Body();
        b.bodyMethod();

        // 调用方式2
        Body.Heart h2 = new Body().new Heart();
        h2.heartMethod();

        Outter o = new Outter();
        o.test(); // 30
                  // 20
                  // 10

        // public >  protect > default > private
        // 内部类的修饰符
        // 外部类 public / default
        // 内部类 4中
        // 局部内部类 0



    }
}
