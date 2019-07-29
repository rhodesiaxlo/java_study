package com.lsx;

import sun.security.krb5.internal.Ticket;

public class DemoThreadSafe {

    public static void main(String[] args) {

        // 创建共享对象

        Tick t = new Tick();


        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();


        // 终止线程，然后再主线程判断
        // 显示结果

        while(t.tick_number > 0)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("打印最后卖出的票张数" + t.list.size());
        System.out.println("卖票详情" + t.list);

        System.out.println("剩余票数" + t.tick_number);


        // 主线程和子线程自建如何调度
        // 如何区分


        // 多线程可以增加执行效率
        // 但是会产生线程问题
        // 不好调度
        // 数据共享的问题
        // 线程的分时 随机
        // 线程的状态
        // new
        // runnable  运行状态
        // block  阻塞状态
        // timed_waiting 计时等待状态
        // waitting(object.wait object.notify)  无限等待状态
        // terminal



    }
}
