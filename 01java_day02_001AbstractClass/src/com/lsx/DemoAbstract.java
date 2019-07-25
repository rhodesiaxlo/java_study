package com.lsx;

public class DemoAbstract {
    public static void main(String[] args) {
        // 笔记，抽象类中不一定有抽象方法，但是有抽象方法的类一定必须是抽象类
        // 无法实例化，必须实例子类
        // 子类必须重写所有抽象方法

        // 运用的时候都是父类的指针调用子类的对象
        Animal cat = new Cat();
        cat.sound();
        cat.eat();
    }
}
