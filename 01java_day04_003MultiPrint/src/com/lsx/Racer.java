package com.lsx;

public class Racer extends Thread{
    private FireFlag flag = null;

    public Racer(FireFlag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        flag.await();
        while(this.flag.getTask()>0) {
            //System.out.println(flag.getTask());
            flag.downTask();
        }
    }
}
