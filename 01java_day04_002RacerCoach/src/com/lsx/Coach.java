package com.lsx;

public class Coach extends  Thread{
    private FireFlag flag = null;

    public Coach(FireFlag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

    }
}
