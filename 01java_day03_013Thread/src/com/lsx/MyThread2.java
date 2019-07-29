package com.lsx;

public class MyThread2 implements  Runnable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 20;
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(this.name + "==>"+i);
        }
    }

    public MyThread2(String name) {
        this.name = name;
    }

    public MyThread2() {
    }
}
