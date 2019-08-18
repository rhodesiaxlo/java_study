package com.lsx;

public class Coff extends BeverageCof{
    @Override
    public void brew() {
        System.out.println("研磨咖啡豆");
    }

    @Override
    public void addCondiment() {
        System.out.println("加奶");
    }
}
