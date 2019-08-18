package com.lsx.impl;

import com.lsx.IPizza;
import com.lsx.IPizzaShop;
import com.lsx.util.PizzaFactory;

public abstract class BasePizzaShop implements IPizzaShop {

    GredientFactory fac = null;

    public BasePizzaShop(GredientFactory fac) {
        this.fac = fac;
    }

    public IPizza order(String ty) {
        IPizza pizza = createPizza(ty);

        pizza.prepare();
        pizza.back();
        pizza.cut();
        pizza.box();

        return  pizza;
    }

    public abstract IPizza createPizza(String ty);
}
