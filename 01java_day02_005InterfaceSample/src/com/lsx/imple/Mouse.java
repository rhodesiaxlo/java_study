package com.lsx.imple;

import com.lsx.IUSB;

public class Mouse implements IUSB {
    @Override
    public void startDevice() {
        System.out.println("开启鼠标");
    }

    @Override
    public void stopDevice() {
        System.out.println("移除鼠标");
    }
}
