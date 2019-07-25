package com.lsx;

import javax.sound.midi.Soundbank;

public class Outter {

    int num = 10;

    public class Inner {
        int num = 20;

        public  void method()
        {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outter.this.num);
        }
    }

    public void test() {
        Inner i = new Inner();
        i.method();
    }
}
