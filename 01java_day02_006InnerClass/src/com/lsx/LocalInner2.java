package com.lsx;

public class LocalInner2 {

    public void method() {

        // 定义局部变量
        int i  = 20;
        //i = 30;
        class MyInner {
            public void innerMethod() {
                // 可以直接访问局部变量，但是该局部变量必须是不变的额
                // 所以最好用 final 修饰
                System.out.println(i);
            }
        }
    }
}
