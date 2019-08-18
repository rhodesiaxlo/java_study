package com.lsx.impl;

public class ZizunGredientFactory extends GredientFactory{
    @Override
    public Dough createDough() {
        return new Dough("至尊专用面团");
    }

    @Override
    public Source createSource() {
        return new Source("至尊独家配方");
    }

    @Override
    public Clam createClam() {
        return  new Clam("至尊海鲜");
    }

    @Override
    public Cheese createCheese() {
        return new Cheese("至尊奶酪");
    }

    @Override
    public Veggie createVeggie() {
        return new Veggie("至尊素食");
    }

    @Override
    public Pepperoni createPepperonßi() {
        return new Pepperoni("至尊香肠");
    }
}
