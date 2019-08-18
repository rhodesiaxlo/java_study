package com.lsx.impl;

public class BiShengpicePizza extends BasePizza {

    public void prepare() {

    }

    public BiShengpicePizza(String name, GredientFactory fac) {
        super(name, fac);
    }

    public BiShengpicePizza(String name) {
        super(name);
    }

    public void back() {
        System.out.println("bisheng: 烘烤20分钟");
    }

    public void cut() {
        System.out.println("bisheng: 切成扇形");

    }

    public void box() {
        System.out.println("bisheng: 装入官方包装盒");

    }
}
