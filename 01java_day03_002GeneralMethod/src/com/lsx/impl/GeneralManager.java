package com.lsx.impl;

import com.lsx.IGeneral;

public class GeneralManager implements IGeneral<String> {

    @Override
    public void method(String a) {
        System.out.println(a);
    }
}
