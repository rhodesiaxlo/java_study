package com.lsx;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tick implements  Runnable{

    public Integer tick_number = 10;
    public ArrayList<Integer> list = new ArrayList<>();

    public Object o = new Object();

    Lock l = new ReentrantLock();
    @Override
    public void run() {

        // 同步代码块
        // sychonized {
        // 同步对象
        //}

//        synchronized (this.o) {
//            while(this.tick_number > 0)
//            {
//                    try {
//                        Thread.sleep(100);
//                        this.list.add(this.tick_number);
//                        System.out.println("卖第" + this.list.size() + "张票" + " 剩余 ticket_number" + this.tick_number);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                this.tick_number--;
//            }
//        }

        // 同步方法
        //synMethod();


        // 锁
        l.lock();
        while(this.tick_number > 0)
        {
                try {
                    Thread.sleep(100);
                    this.list.add(this.tick_number);
                    System.out.println("卖第" + this.list.size() + "张票" + " 剩余 ticket_number" + this.tick_number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    l.unlock();
                }

            this.tick_number--;
        }

    }

    public synchronized  void synMethod()
    {
        while(this.tick_number > 0)
        {
            try {
                Thread.sleep(100);
                this.list.add(this.tick_number);
                System.out.println("卖第" + this.list.size() + "张票" + " 剩余 ticket_number" + this.tick_number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.tick_number--;
        }
    }
}
