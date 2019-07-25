package com.lsx;

import com.lsx.imple.Keyboard;
import com.lsx.imple.Mouse;

import java.awt.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        IUSB mouse = new Mouse();
        IUSB keyboard = new Keyboard();

        ArrayList<IUSB>  listDevice = new ArrayList<>();
        listDevice.add(mouse);
        listDevice.add(keyboard);

        Laptop l = new Laptop(listDevice);

        l.powerOn();
        l.run();
        l.powerOff();

    }
}
