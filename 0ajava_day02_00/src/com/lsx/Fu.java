package com.lsx;

public class Fu {
    public void method()
    {
        System.out.println("fu 中的 final 方法");
    }

    public final void finalMethod()
    {
        System.out.println("final 方法不能被重写");
    }

}
