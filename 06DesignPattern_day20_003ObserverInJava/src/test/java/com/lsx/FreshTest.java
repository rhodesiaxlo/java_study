package com.lsx;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class FreshTest {

    @Test
    public void freshTest() {

        // 考虑多线程
        //


        Obj1 obj1 = new Obj1();

        Observer t1 = new Observ("terminal1");
        Observer t2 = new Observ("terminal2");
        Observer t3 = new Observ("terminal3");
        Observer t4 = new Observ("terminal4");

        obj1.addObserver(t1);
        obj1.addObserver(t2);
        obj1.addObserver(t3);

        // 触发事件
        obj1.setTemp(10);
        System.out.println("===============");
        obj1.setTemp(20);
        System.out.println("===============");
        obj1.deleteObserver(t1);
        obj1.setTemp(30);


    }
}
