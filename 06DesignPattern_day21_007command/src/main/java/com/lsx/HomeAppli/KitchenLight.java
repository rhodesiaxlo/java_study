package com.lsx.HomeAppli;

public class KitchenLight extends  ILight{

    @Override
    public void lightOn() {
        System.out.println("卧室灯开启");
    }

    @Override
    public void lightOff() {
        System.out.println("卧室灯关闭");
    }
}
