package com.lsx;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Laptop {

    private ArrayList<IUSB> devices = null;

    public void powerOn() {
        System.out.println("开机");
    }

    public void powerOff() {
        for (int i = 0; i < devices.size(); i++) {
            devices.get(i).stopDevice();
        }
        System.out.println("关机");
    }

    public void run() {
        for (int i = 0; i < devices.size(); i++) {
            devices.get(i).startDevice();
        }
    }

    public Laptop(ArrayList<IUSB> devices) {
        this.devices = devices;
    }

    public Laptop() {
    }

    public ArrayList<IUSB> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<IUSB> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "devices=" + devices +
                '}';
    }
}
