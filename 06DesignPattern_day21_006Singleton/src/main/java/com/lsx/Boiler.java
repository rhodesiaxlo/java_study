package com.lsx;


import static java.lang.Thread.sleep;

public class Boiler {
    private  Boolean isBoiled = false;
    private  boolean isEnd = false;

    public  Integer index = 0;

    public Boolean getBoiled() {
        return isBoiled;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    private  Boolean isEmpty = true;

    public synchronized void fill() {
        if(isEmpty&&!isEnd) {
            System.out.println("加入500公斤原材料");
            isEmpty=false;
        }
    }

    public synchronized  void boil() {
        if(!isEmpty&&!isBoiled&&!isEnd) {
            System.out.println("加热");

            isBoiled=true;
        }
    }

    public  synchronized  void drain() {
        if(!isEmpty&&isBoiled&&!isEnd) {
            System.out.println("出锅");

            isEmpty=true;
            isBoiled=false;
            isEnd = true;

        }
    }

}
