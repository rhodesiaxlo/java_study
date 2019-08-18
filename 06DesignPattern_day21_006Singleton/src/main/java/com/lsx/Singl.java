package com.lsx;


import static java.lang.Thread.sleep;

public  class Singl {

    public  static Boiler boil = null;

//    public  static  Boiler  getBoiler() throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        if(null == boil) {
//            synchronized (Singl.class) {
//                if(null == boil) {
//                    boil = new Boiler();
//                }
//            }
//        }
//
//        return boil;
//    }

    public  static synchronized Boiler getBoiler() throws  InterruptedException {
        System.out.println(Thread.currentThread().getName());
        if(null == boil) {
            boil = new Boiler();
        }

        return boil;
    }
}
