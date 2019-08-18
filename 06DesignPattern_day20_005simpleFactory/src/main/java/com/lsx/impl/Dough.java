package com.lsx.impl;

public class Dough {

    private String name;


    public Dough(String name) {
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
        return "Dough{" +
                "name='" + name + '\'' +
                '}';
    }
}
