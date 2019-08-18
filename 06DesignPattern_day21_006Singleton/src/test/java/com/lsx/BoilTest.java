package com.lsx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoilTest {

    @Test
    public  void boilTest() {
        // 流程控制
        // 开1000 个现成


        List<Runnable> list = new ArrayList<Runnable>();

        // 这里写的是同步代码
        for (int i = 0; i < 10000; i++) {

            new Thread(new Runnable() {
                public void run() {
                    try {
                        Singl.getBoiler();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        System.out.println("我跑完了");




    }
}
