package com.lsx;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

class MyBlockingQueue<E> {
    private Queue<E> queue = null;

    private int limit;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }

    // 静态同步代码块
    public synchronized  void put(E e) throws InterruptedException {
        while(queue.size() == limit) {
//            System.out.println("队列已放满，put 进入无限休眠状态");
            wait();
        }

        // 唤醒
//        System.out.println("put 被唤醒，put ...");
        queue.add(e);

        // 执行下一波操作
        notifyAll();
    }

    public  synchronized  E take() throws InterruptedException {
        while(queue.isEmpty()) {
//            System.out.println(" 队列已取空，take 进入无限休眠");
            wait();
        }

        // 被唤醒
        E e = queue.poll();
        notifyAll();

        return e;
    }
}
