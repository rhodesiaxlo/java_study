package com.lsx;

public class LocalInner {
    public void method()
    {
        // 局部内部类什么修饰符都不能添加
        class Test {
            public void method2()
            {
                System.out.println("local inner class method");
            }

        }

        Test t = new Test();
        t.method2();
    }
}
