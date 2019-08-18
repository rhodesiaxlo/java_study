package com.lsx.impl;

public class BiShengVeggiePizza extends BasePizza {


    public void prepare() {

    }

    public BiShengVeggiePizza() {
    }

    public BiShengVeggiePizza(String name, GredientFactory fac) {
        super(name, fac);
    }

    public BiShengVeggiePizza(String name) {
        super(name);
    }

    public void back() {
        System.out.println("bisheng: 烘烤15分钟");
    }

    public void cut() {
        System.out.println("bisheng: 切成扇形");

    }

    public void box() {
        System.out.println("bisheng: 官方包装盒");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
