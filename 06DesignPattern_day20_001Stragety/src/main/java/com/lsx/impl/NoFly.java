package com.lsx.impl;

import com.lsx.IFlyBehavior;

public class NoFly implements IFlyBehavior {
    public void fly() {
        System.out.println("不能飞行");
    }
}
