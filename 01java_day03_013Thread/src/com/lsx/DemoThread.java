package com.lsx;

import javax.sound.midi.Soundbank;

public class DemoThread {

    // 单核 多核
    // 进程 线程
    // 并行 平行
    // 线程调度  分时调度 抢占调度

    public static void main(String[] args) {
        // 如何开启一个线程
        // 1. 继承 thread
        // 2. 重写 run 方法
        // 3. 创建 子类
        // 4. 条用 start

//        MyThread t1 = new MyThread("小强", "小强");
//        MyThread t2 = new MyThread("旺财", "旺财");
//
//        t1.setMyname("thread1");
//        t2.setMyname("thread2");
//
//        System.out.println();
//        t1.start();
//        t2.start();

        // 开启线程的第二个方法2

        MyThread2 t22 = new MyThread2("小强");
        MyThread2 t23 = new MyThread2("旺财");

        new Thread(t22).start();
        new Thread(t23).start();


        // 2 中线程实现方式的区别
        // runnerable 解耦了
        // 更灵活，因为java 不能实现多继承

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=20;
                while(i>0) {
                    System.out.println("hello world" + "==>" + i);
                    i--;
                }
            }
        }).start();

    }
}
