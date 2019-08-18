package com.lsx.impl;

public class BiShengIngredientFactory extends GredientFactory{
    @Override
    public Dough createDough() {
        return new Dough("必胜客专用面团");
    }

    @Override
    public Source createSource() {
        return new Source("必胜客独家配方");
    }

    @Override
    public Clam createClam() {
        return  new Clam("必胜客海鲜");
    }

    @Override
    public Cheese createCheese() {
        return new Cheese("必胜客奶酪");
    }

    @Override
    public Veggie createVeggie() {
        return new Veggie("必胜客素食");
    }

    @Override
    public Pepperoni createPepperonßi() {
        return new Pepperoni("必胜客香肠");
    }
}
