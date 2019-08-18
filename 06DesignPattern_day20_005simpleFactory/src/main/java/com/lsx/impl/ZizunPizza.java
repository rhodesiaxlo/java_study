package com.lsx.impl;

import com.lsx.IPizza;
import com.lsx.IPizzaShop;
import com.lsx.util.PizzaFactory;

public class ZizunPizza extends BasePizzaShop {
    public ZizunPizza(GredientFactory fac) {
        super(fac);
    }

    @Override
    public IPizza createPizza(String ty) {
        IPizza p = null;
        if("veggie".equalsIgnoreCase(ty)) {
            p = new ZizunVeggiePizza();
        }else if("spice".equalsIgnoreCase(ty)){
            p = new ZizunpicePizza();
        } else if("meat".equalsIgnoreCase(ty)) {
            p = new ZizunMeatPizza();
        }

        return p;
    }
}
