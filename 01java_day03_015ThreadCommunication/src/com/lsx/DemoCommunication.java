package com.lsx;

public class DemoCommunication {
    public static void main(String[] args) {
        // 线程通信示例
        // 无限等待

        // 同步对象
        Object o = new Object();

        new Thread() {
            @Override
            public void run() {
                // 不断下单
                while (true) {
                    synchronized (o) {
                        System.out.println("顾客1  告诉老板包子的种类和数量,等待...");
                        // 进入无限等待状态，等待唤醒
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // 被唤醒之后，继续执行代码
                        System.out.println("包子上桌了，顾客1 开吃...");
                        System.out.println("-------------------------");

                    }
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                // 不断下单
                while (true) {
                    synchronized (o) {
                        System.out.println("顾客2  告诉老板包子的种类和数量,等待...");
                        // 进入无限等待状态，等待唤醒

                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // 被唤醒之后，继续执行代码
                        System.out.println("包子上桌了，顾客2 开吃...");
                        System.out.println("-------------------------");

                    }
                }

            }
        }.start();


        new Thread() {
            @Override
            public void run() {;

                while(true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        synchronized (o) {
                        System.out.println("老板做包子。。。");
                        System.out.println("包子做好了，上包子...");
                        //唤醒消费者
                        o.notify();
                    }
                }
            }
        }.start();
    }
}
