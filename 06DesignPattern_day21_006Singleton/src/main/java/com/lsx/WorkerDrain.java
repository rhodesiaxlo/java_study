package com.lsx;

import static java.lang.Thread.sleep;

public class WorkerDrain implements Runnable{
    public void run() {

        try {
            sleep(10000);
            Boiler boiler = Singl.getBoiler();
            boiler.fill();
            boiler.boil();
            boiler.drain();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
