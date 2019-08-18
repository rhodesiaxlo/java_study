package com.lsx.impl;

public class Veggie {

    private String name;

    public Veggie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Veggie{" +
                "name='" + name + '\'' +
                '}';
    }
}
