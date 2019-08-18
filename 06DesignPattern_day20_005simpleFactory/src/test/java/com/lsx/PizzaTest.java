package com.lsx;

import com.lsx.impl.*;
import com.lsx.util.PizzaFactory;
import org.junit.Test;

public class PizzaTest {

    /**
     * 缺点： shop 和 各种 pissa 强依赖
     * 修改或者删除披萨都需要动 店铺
     * 这在多个店铺里面是不太合适的
     *
     * 多种披萨，多种店铺
     */
    @Test
    public  void PizzaTest() {
//        PizzaFactory fac = new PizzaFactory();
//        IPizzaShop shop1 = new ZizunPizza(fac);
//        shop1.order("veggie");
//
//        System.out.println("-----------");
//
//        IPizzaShop shop2 = new BishengPizzaShop(fac);
//        shop2.order("meat");
//
//
//        System.out.println("---------------");
//        IPizzaShop shop3 = new OtherPizzaShop(fac);
//        shop3.order("spice");
    }

    @Test
    /**
     * 披萨店可以有自己的改良
     */
    public void cusPizzaTest() {
        BiShengIngredientFactory bishengfac = new BiShengIngredientFactory();
        BishengPizzaShop shop = new BishengPizzaShop(bishengfac);

        shop.order("veggie");

        //ZizunGredientFactory fac2 = new ZizunGredientFactory();



    }


}
