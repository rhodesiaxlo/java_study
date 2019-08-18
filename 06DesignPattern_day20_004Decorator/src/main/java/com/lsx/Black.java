package com.lsx;

public class Black extends Beverage{
    @Override
    public String desc() {
        return "Black coffee";
    }

    @Override
    public Float getCost() {
        return 30.0F;
    }
}
