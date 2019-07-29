package com.lsx;

public class DemoMultiThread {


    public static void main(String[] args) {
        // 实验生产者消费者模式

       // System.out.println("value of "+ String.valueOf(0));

        // limit = 100 是交替关键
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10000);

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        p.start();
        c.start();

    }
}
