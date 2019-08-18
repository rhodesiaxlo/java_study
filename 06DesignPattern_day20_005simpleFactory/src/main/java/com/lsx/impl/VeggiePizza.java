package com.lsx.impl;

import com.lsx.IPizza;

public class VeggiePizza implements IPizza {
    public void prepare() {
        System.out.println("面+ 素食");
    }

    public void back() {
        System.out.println("烘烤");
    }

    public void cut() {
        System.out.println("切块");
    }

    public void box() {
        System.out.println("装箱");
    }
}
