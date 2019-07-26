package com.lsx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DemoPoker {

    public static void main(String[] args) {


        // 构造牌
        ArrayList<String> poker = new ArrayList<>();
        poker.add("大王");
        poker.add("小王");

        String[] colors = {"♥", "♦", "♠", "♣"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        for (String color : colors) {
            for (String number : numbers) {
                poker.add(color+number);
            }
        }
        System.out.println("组装牌开始" + poker);
        // 洗牌
        Collections.shuffle(poker);

        System.out.println("洗牌后" + poker);

        // 发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> reser = new ArrayList<>();
        for (int i = 0; i < poker.size()-3; i++) {
            String tmp = poker.get(i);
            if(i%3==0) {
                player1.add(tmp);
            } else if (i % 3 ==1) {
                player2.add(tmp);
            } else {
                player3.add(tmp);
            }
        }

        reser.add(poker.get(poker.size()-1));
        reser.add(poker.get(poker.size()-2));
        reser.add(poker.get(poker.size()-3));


        // 看牌
        System.out.println("玩家1 的牌" + player1);
        System.out.println("玩家2 的牌" + player2);
        System.out.println("玩家3 的牌" + player3);
        System.out.println("底牌" + reser);
    }
}
