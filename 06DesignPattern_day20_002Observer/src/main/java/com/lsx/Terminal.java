package com.lsx;

public class Terminal implements IDisplay, IObser{

    private Integer temper;
    private String name;

    public Terminal(String name) {
        this.name = name;
    }

    public Integer getTemp() {
        return temper;
    }

    public void setTemp(Integer temp) {
        this.temper = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {

        System.out.println( name + " refreshing,  temperature is : " + temper);
    }

    public void update(Integer temp) {
        temper = temp;
        display();
    }
}
