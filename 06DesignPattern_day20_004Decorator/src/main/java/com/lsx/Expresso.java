package com.lsx;

public class Expresso extends Beverage{
    @Override
    public String desc() {
        return "expresso ";
    }

    @Override
    public Float getCost() {
        return 10.0F;
    }
}
