package com.lsx;

import sun.font.FontRunIterator;

public class DemoRacer {
    public static void main(String[] args) throws InterruptedException {
        // 创建协作对象
        int num = 10;
        FireFlag flag = new FireFlag();
        Thread[] racers = new Thread[num];

        for (int i = 0; i <num; i++) {
            racers[i] = new Racer(flag);
            racers[i].start();
        }

        // 开枪
        flag.fire();


        // object 锁对象卡死了其它线程，所以这里延迟5秒的，等待其它线程执行完就可以成功执行了
        Thread.sleep(5000);
        // 等待系统执行完
         flag.await();
        // 打印输出结果
         System.out.println(flag);



    }

}
