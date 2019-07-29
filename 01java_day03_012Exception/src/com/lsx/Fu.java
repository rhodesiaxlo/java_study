package com.lsx;


public class Fu {

    // 子父类异常的关系
    // 父类什么异常，子类抛出什么异常
    void method() throws  NullPointerException,ClassCastException{}{};

    // 父类抛出什么异常，子类可以抛出子类
    void method2() throws ArrayIndexOutOfBoundsException{};

    // 父类有异常，子类不写异常
    void method3() throws IndexOutOfBoundsException {};

    // 父类没有异常，子类不能抛出异常
    void method4() {};

}

class Zi extends Fu {
    @Override
    void method() throws NullPointerException, ClassCastException,IndexOutOfBoundsException {
        super.method();
    }

    @Override
    void method2() throws IndexOutOfBoundsException {
        super.method2();
    }

    @Override
    void method3() {
        super.method3();
    }

    @Override
    void method4() throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException();
    }
}
