package com.lsx;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class BeverageCof {

    public  void prepare() {
        boilWater();
        brew();
        pourinWater();
        if(customerWantsCondi()) {
            addCondiment();
        }
    }

    public  void boilWater() {
        System.out.println("boil water...");
    }

    public void brew() {

    }

    public void pourinWater() {
        System.out.println("pour in water");
    }

    public void addCondiment() {

    }

    public Boolean customerWantsCondi() {
        return getInput();
    }

    public Boolean getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("需要添加调味吗? 是 Y  否 n");
        String s = null;
        while (sc.hasNext()){
            s = sc.nextLine();
            if("y".equalsIgnoreCase(s)) {
                sc.close();
                return true;
            } else {
                sc.close();
                return false;
            }
        }

        if("y".equalsIgnoreCase(s)) {
            sc.close();
            return true;
        } else {
            sc.close();
            return false;
        }


    }
}
