package com.lsx;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class DemoConvert {
    public static void main(String[] args) {

        // 向上转型
        Animal a = new Cat();
        a.eat();

        // 向下转型
        //a.catchMouse();
        Cat c = (Cat)a;
        c.catchMouse();

        // 如何判断如何向下转型
        System.out.println(a instanceof  Cat);
        System.out.println(a instanceof  Dog);

        // 所以可以向猫转型，不能向 dog 转型


    }
}
