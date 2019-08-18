package com.lsx;

import java.util.Observable;
import java.util.Observer;

public class Observ implements Observer ,IDisplay{


    private String name;

    private Integer temp;

    private Observable obj;

    public Observ(String name) {
        this.name = name;
    }

    public Observ() {
    }

    public void update(Observable o, Object arg) {
        obj = o;
        temp = (Integer)arg;

        display();
    }

    public void display() {
        System.out.println(name + " refreshing, temp = " + temp);
    }
}
