package com.lsx;

import java.sql.SQLOutput;

public class GeneralMethodManager {

    public  <M> void generalMethod(M a)
    {
        System.out.println(a);
    }

    public static <M> void staticMethod(M a)
    {
        System.out.println(a);
    }

}
