package com.lsx.impl;

public class MeatPizza implements com.lsx.IPizza {

    public void prepare() {
        System.out.println("面 + 肉");
    }

    public void back() {
        System.out.println("烘焙");
    }

    public void cut() {
        System.out.println("切块");
    }

    public void box() {
        System.out.println("装箱");
    }
}
