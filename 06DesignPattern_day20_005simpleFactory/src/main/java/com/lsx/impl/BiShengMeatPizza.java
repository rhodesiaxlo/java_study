package com.lsx.impl;

public class BiShengMeatPizza extends BasePizza {

    public void prepare() {

    }

    public BiShengMeatPizza(String name, GredientFactory fac) {
        super(name, fac);
    }

    public BiShengMeatPizza(String name) {
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
}
