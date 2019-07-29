package com.lsx;

import javax.sound.midi.Soundbank;

public class Producer extends  Thread{
    private MyBlockingQueue<String> queue;

    public Producer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        int num = 0;
        while(true) {
            // 创建任务
            String task = String.valueOf(num);

            try {
                queue.put(task);
                System.out.println("product task " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num++;
            try {
                Thread.sleep((int)Math.random()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
