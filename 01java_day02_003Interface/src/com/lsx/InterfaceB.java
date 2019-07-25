package com.lsx;

public interface InterfaceB {
    void methodB();

    void method();

    default void defaultMethod()
    {
        System.out.println("default method from interface B");
    }
}
