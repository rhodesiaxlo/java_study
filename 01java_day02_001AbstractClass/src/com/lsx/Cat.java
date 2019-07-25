package com.lsx;

public class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("喵");
    }

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
