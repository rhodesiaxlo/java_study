package com.lsx.impl;

import com.lsx.IPizza;
import com.lsx.IPizzaShop;
import com.lsx.util.PizzaFactory;

public class BishengPizzaShop extends BasePizzaShop {

    public BishengPizzaShop(GredientFactory fac) {
        super(fac);
    }

    @Override
    public IPizza createPizza(String ty) {
        IPizza p = null;
        if("veggie".equalsIgnoreCase(ty)) {
            p = new BiShengVeggiePizza("必胜客素食披萨", fac);
        }else if("spice".equalsIgnoreCase(ty)){
            p = new BiShengpicePizza("必胜客香辣披萨", fac);
        } else if("meat".equalsIgnoreCase(ty)) {
            p = new BiShengMeatPizza("必胜客海鲜披萨", fac);
        }

        System.out.println(p);
        return p;
    }
}
