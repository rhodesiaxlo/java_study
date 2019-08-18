package com.lsx.impl;

public class SpicePizza implements com.lsx.IPizza {

    public void prepare() {
        System.out.println("面 + 辣椒");
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
