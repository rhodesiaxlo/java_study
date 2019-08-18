package com.lsx;

/**
 * duck 出现类，定义了 duck 的基本方法
 *
 * 继承有很强的威力，可以用统一的方式条用不同对象的行为
 * 但是行为固化在实体 且 多级继承的时候，使用和修改会十分复杂
 * 试想一个10级继承，因为某种原因，中间某一个类必须要改写某种方法，但是这种方法并不为后面子类所共有，
 * 则 你必须改后面中有些子类，而不是所有子类
 *
 * 解决办法， 组合 + 接口  + 多台
 */
public abstract class Duck {

    private IQuackBehavior  quackBehavior;

    private IFlyBehavior flyBehavior;

    void swim(){};

    void performSount() {
        quackBehavior.quack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    public IQuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(IQuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public IFlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(IFlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    @Override
    public String toString() {
        performSount();
        performFly();
        return null;
    }
}
