package com.lsx;

public class HouseBlend extends Beverage{
    @Override
    public String desc() {
        return "house blend";
    }

    @Override
    public Float getCost() {
        return 20.0F;
    }
}
