package com.lsx;

public class User {
    private final  Integer name = 1234;

    public void change()
    {
        // final 修饰的成员变量无法被修改
        // this.name = 1111;
    }

}
