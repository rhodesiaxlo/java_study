package com.lsx.impl;

import com.lsx.IPizza;
import com.lsx.util.PizzaFactory;

public class OtherPizzaShop extends BasePizzaShop{
    public OtherPizzaShop(GredientFactory fac) {
        super(fac);
    }

    @Override
    public IPizza createPizza(String ty) {
        return null;
    }
}
