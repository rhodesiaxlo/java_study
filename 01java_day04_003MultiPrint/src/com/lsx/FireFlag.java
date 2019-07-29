package com.lsx;

public class FireFlag {

    // 线程数
    private Integer num = 0;
    private Integer task = 0;

    public FireFlag(int num,int task) {
        this.num = num;
        this.task = task;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public synchronized void await() {
        while (num >0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  synchronized  void countDown() {
        this.num--;

        if(num <=0) {
            notifyAll();
        }
    }

    public synchronized void downTask() {
        task--;
    }
}
