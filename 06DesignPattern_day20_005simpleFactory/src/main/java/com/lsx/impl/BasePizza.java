package com.lsx.impl;

import com.lsx.IPizza;

public class BasePizza implements IPizza {
    // 增加原料
    private String name;
    private Dough dough;
    private Source source;
    private Veggie veggie;
    private Pepperoni pepp;
    private Cheese cheese;
    private Clam clam;

    public BasePizza(String name, GredientFactory fac) {
        this.name = name;
        this.fac = fac;

        source = fac.createSource();
        dough = fac.createDough();
        veggie = fac.createVeggie();
        cheese = fac.createCheese();
        clam = fac.createClam();
        pepp = fac.createPepperonßi();


    }

    private GredientFactory fac = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Source getSource() {
        return source;
    }


    public void setSource(Source source) {
        this.source = source;
    }

    public Veggie getVeggie() {
        return veggie;
    }

    public void setVeggie(Veggie veggie) {
        this.veggie = veggie;
    }

    public Pepperoni getPepp() {
        return pepp;
    }

    public void setPepp(Pepperoni pepp) {
        this.pepp = pepp;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Clam getClam() {
        return clam;
    }

    public void setClam(Clam clam) {
        this.clam = clam;
    }

    public BasePizza(String name) {
        this.name = name;
    }

    public BasePizza() {
    }

    public void prepare() {

    }

    public void back() {

    }

    public void cut() {

    }

    public void box() {

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", source=" + source +
                ", veggie=" + veggie +
                ", pepp=" + pepp +
                ", cheese=" + cheese +
                ", clam=" + clam +
                '}';
    }
}
