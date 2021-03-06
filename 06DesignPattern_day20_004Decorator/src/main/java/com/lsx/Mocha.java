package com.lsx;

public class Mocha extends Decorator{

    public Mocha(Beverage wrapper) {
        super(wrapper);
    }

    public Mocha() {
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
        return super.desc() + " add mocha";
    }

    @Override
    public Float getCost() {
        return super.getCost() + 7.0F;
    }
}
