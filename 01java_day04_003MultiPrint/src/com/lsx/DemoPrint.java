package com.lsx;

import java.util.concurrent.ConcurrentLinkedDeque;

public class DemoPrint {

    public static void main(String[] args) {
        // 主线程


        // 打印 1亿 条 hello world 比执行 1亿次数学运算慢 1000 倍，能否使用多线程来增加速度
        // 多线程可以增加 io 效率吗 ？

        // 可以使用同时模式
        Integer task = 1000000;

        FireFlag flag = new FireFlag(1, task);

        int thread_num  = 10000;
        Racer[] racers = new Racer[thread_num];
        for (int i = 0; i < thread_num; i++) {
            racers[i] = new Racer(flag);
            racers[i].start();
        }

        long l = System.currentTimeMillis();

        System.out.println("====" + Thread.activeCount());

        // 开始
        flag.countDown();

        while(true) {
            if(Thread.activeCount()<=2) {
                System.out.println("time consuming: " + (System.currentTimeMillis()-l));
                System.out.println("====" + Thread.activeCount());

                System.exit(0);
            }
        }

    }
}
