package com.lsx;

/**
 * 装饰者对象 行为一致的
 * 分主次
 * 无明显的逻辑关系
 */
public class Decorator extends Beverage{


    private  Beverage wrapper;

    public Beverage getWrapper() {
        return wrapper;
    }

    public void setWrapper(Beverage wrapper) {
        this.wrapper = wrapper;
    }

    public Decorator(Beverage wrapper) {
        this.wrapper = wrapper;
    }

    public Decorator() {
    }

    @Override
    public String desc() {
        return wrapper.desc() + "," + super.desc();
    }

    @Override
    public Float getCost() {
        return wrapper.getCost() + super.getCost();
    }
}
