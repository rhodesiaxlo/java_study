package com.lsx.util;

import com.lsx.IPizza;
import com.lsx.impl.MeatPizza;
import com.lsx.impl.SpicePizza;
import com.lsx.impl.VeggiePizza;

public class PizzaFactory {

    public IPizza getPizza(String ty) {
        IPizza p = null;
        if("veggie".equalsIgnoreCase(ty)) {
            p = new VeggiePizza();
        }else if("spice".equalsIgnoreCase(ty)){
            p = new SpicePizza();
        } else if("meat".equalsIgnoreCase(ty)) {
            p = new MeatPizza();
        }

        return p;
    }
}
