package com.lsx;

// 发令枪对象
public class FireFlag {
    private volatile boolean fired = false;

    public Integer num = 0;


    public synchronized  void waitFire() throws InterruptedException {
        while(!fired) {
            wait();
        }
    }

    public synchronized  void fire() {

        this.fired = true;
        notifyAll();
    }

    public synchronized void   waitAssem() throws InterruptedException {
        while(this.num>0) {
            wait();
        }
    }

    public  synchronized void countDown() {
        this.num--;
        System.out.println(Thread.currentThread().getName() + " 结束执行 计数器 " + this.num);
        if(this.num<=0) {
            notifyAll();
        }
    }


}
