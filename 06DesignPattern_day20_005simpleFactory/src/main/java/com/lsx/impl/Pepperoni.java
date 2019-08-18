package com.lsx.impl;

public class Pepperoni {
    private  String name;


    public Pepperoni(String name) {
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
        return "Pepperoni{" +
                "name='" + name + '\'' +
                '}';
    }
}
