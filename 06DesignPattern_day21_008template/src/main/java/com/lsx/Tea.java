package com.lsx;

public class Tea extends BeverageCof{

    @Override
    public void brew() {
        System.out.println("浸泡茶包");
    }

    @Override
    public void addCondiment() {
        System.out.println("加柠檬");
    }
}
