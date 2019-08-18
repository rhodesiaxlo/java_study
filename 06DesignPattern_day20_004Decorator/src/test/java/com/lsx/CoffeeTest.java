package com.lsx;

import org.junit.Test;

public class CoffeeTest {

    /**
     * 装饰者模式 decorator 测试
     * 拓展逻辑的另外一种方式
     *
     * 对象似乎是平行关系
     * 对象属性类似
     * java.io
     *
     * 对象可以任意组合
     *
     *
     *
     * 策略者模式 stragety
     * 行为类似
     * 行为不确定
     * 继承关系不明确
     */
    @Test
    public  void coffeeTest() {
        Beverage black = new Black();
        Beverage houseBl = new HouseBlend();


        Decorator milk = new Milk();
        milk.setWrapper(black);
        Decorator whilp = new Whilp();
        whilp.setWrapper(milk);

        System.out.println(whilp.desc());
        System.out.println(whilp.getCost());


        // 依赖注入
        // 依赖
        Beverage h1 = new Milk(houseBl);
        Beverage h2 = new Whilp(h1);

        System.out.println("--------------");
        System.out.println(h2.desc());
        System.out.println(h2.getCost());




    }
}
