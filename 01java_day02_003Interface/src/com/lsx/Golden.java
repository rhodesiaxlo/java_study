package com.lsx;

public class Golden extends Dog{
    @Override
    public void sound() {
        System.out.println("汪汪汪");
    }

    @Override
    public void swim() {
        System.out.println("不会");

    }

    @Override
    public void eat() {
        System.out.println("呜呜呜");
    }
}
