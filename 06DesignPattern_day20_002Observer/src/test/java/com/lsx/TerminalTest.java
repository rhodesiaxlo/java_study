package com.lsx;

import org.junit.Test;

public class TerminalTest {

    @Test
    public  void freshTest() {
        Object1 obj = new Object1();

        Terminal t1 = new Terminal("terminal1");
        Terminal t2 = new Terminal("terminal2");
        Terminal t3 = new Terminal("terminal3");
        Terminal t4 = new Terminal("terminal4");

        obj.registerObser(t1);
        obj.registerObser(t2);
        obj.registerObser(t4);

        // 事件
        obj.setTemp(10);
        obj.setTemp(20);
        obj.removeObser(t1);
        obj.setTemp(30);






    }
}
