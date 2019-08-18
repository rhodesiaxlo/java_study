package com.lsx;

public class Milk extends Decorator{

    public Milk(Beverage wrapper) {
        super(wrapper);
    }

    public Milk() {
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
        return super.desc()+" add milk";
    }

    @Override
    public Float getCost() {
        return super.getCost()+1.5F;
    }
}
