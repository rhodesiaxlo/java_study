package com.lsx;

import java.util.ArrayList;

public class DemoAbs {

    public static void main(String[] args) {
        Manager m = new Manager("群主", 100);

        Member m1 = new Member("张三", 0);
        Member m2 = new Member("李四", 0);
        Member m3 = new Member("王五", 0);
        Member m4 = new Member("王麻子", 0);

        ArrayList<Integer> redList = m.send(20, 3);

        System.out.println(redList);

        m1.receive(redList);
        m2.receive(redList);
        m3.receive(redList);
        m4.receive(redList);


        // 遍历
        m.show();
        m1.show();
        m2.show();
        m3.show();
        m4.show();


    }
}
