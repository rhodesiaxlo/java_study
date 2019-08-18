package com.lsx;

public class Demo {

    public static void main(String[] args) {
        // 这里写的是同步代码
        for (int i = 0; i < 100; i++) {
            new Thread(new WorkerDrain()).start();
        }



        // 异步如何计算时间
        System.out.println("我跑完了");
    }
}
