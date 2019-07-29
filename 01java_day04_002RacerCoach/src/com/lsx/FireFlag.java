package com.lsx;

// 发令枪对象
public class FireFlag {
    private volatile boolean fired = false;
    private Integer num = 0;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
        System.out.println("创建线程 计数器 " +this.num);
    }

    public synchronized  void waitFire() throws InterruptedException {
        while(!fired) {
            wait();
        }
    }

    public synchronized  void fire() {
        this.fired = true;
    }

    // 集结
    public synchronized void countDown() {

        this.num--;
        System.out.println(Thread.currentThread().getName() + "结束执行... 计数器" + this.num);

        if(this.num<=0)
        {
            notifyAll();
        }
    }


    // 集合调度
    public synchronized void await() throws InterruptedException {
        while(this.num >0) {
           wait();
        }
    }

    @Override
    public String toString() {
        return "FireFlag{" +
                "fired=" + fired +
                ", num=" + num +
                '}';
    }
}
