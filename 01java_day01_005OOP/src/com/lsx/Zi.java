package com.lsx;

public class Zi extends  Fu{
    String var1 = "zi";

    @Override
    public void method()
    {
        System.out.println(var1);
    }

    public void methodZi()
    {
        System.out.println(var1);
    }

    public void methodZiScope()
    {
        String var1 = "local ";
        System.out.println(var1);
        System.out.println(this.var1);
        System.out.println(super.var1);
    }
}
