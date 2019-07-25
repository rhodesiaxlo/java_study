package com.lsx;

public interface InterfaceA {

    void methodA();

    void method();

    default void defaultMethod()
    {
        System.out.println("default method from 接口A");
    }

}
