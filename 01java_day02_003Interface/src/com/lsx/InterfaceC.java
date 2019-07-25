package com.lsx;

public interface InterfaceC extends  InterfaceA, InterfaceB{

    @Override
    default void defaultMethod() {
        System.out.println("default method from InterfaceC");
    }
}
