package com.lsx.imple;

import com.lsx.IUSB;

public class Keyboard implements IUSB {
    @Override
    public void startDevice() {
        System.out.println("开启键盘");
    }

    @Override
    public void stopDevice() {
        System.out.println("移除键盘");
    }
}
