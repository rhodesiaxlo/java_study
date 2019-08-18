package com.lsx;

public class Whilp extends Decorator{

    public Whilp(Beverage wrapper) {
        super(wrapper);
    }

    public Whilp() {
    }

    @Override
    public Beverage getWrapper() {
        return super.getWrapper();
    }

    @Override
    public void setWrapper(Beverage wrapper) {
        super.setWrapper(wrapper);
    }

    @Override
    public String desc() {
        return super.desc() + " add whilp ";
    }

    @Override
    public Float getCost() {
        return super.getCost() + 5.0F;
    }
}
