package com.lsx;

import sun.font.FontRunIterator;

public class DemoRacer {
    public static void main(String[] args) throws InterruptedException {
        // 创建协作对象
        int num =10;
        FireFlag flag = new FireFlag();
        Thread[] racers = new Thread[num];

        for (int i = 0; i <num; i++) {
            racers[i] = new Racer(flag);
            racers[i].start();
        }

        // 开枪
        flag.fire();


//        boolean close = false;
//        while(!close) {
//            int i;
//            for (i = 0; i < 10; i++) {
//                if(racers[i].isAlive()) {
//                    break;
//                }
//            }
//
//            if(i==10) {
//                close = true;
//
//            }
//        }

        flag.waitAssem();

        System.out.println(" 结束执行");




    }

}
