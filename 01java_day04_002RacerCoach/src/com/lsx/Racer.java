package com.lsx;

public class Racer extends Thread{
    private FireFlag flag = null;

    public Racer(FireFlag flag) {
        this.flag = flag;
        flag.setNum(flag.getNum()+1);
    }

    @Override
    public void run() {
        try {
            this.flag.waitFire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 被唤醒
        System.out.println("开始跑" + Thread.currentThread().getName());

        // 消失进程
        flag.countDown();
    }
}
