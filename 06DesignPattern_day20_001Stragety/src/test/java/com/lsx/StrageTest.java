package com.lsx;

import com.lsx.impl.GuGu;
import com.lsx.impl.GuaGua;
import com.lsx.impl.NoFly;
import com.lsx.impl.RocketFly;
import org.junit.Test;

public class StrageTest {

    @Test
    public void quackTest() {
        Duck duck1 = new MallardDuck();

        IQuackBehavior guagua = new GuaGua();
        IQuackBehavior gugu = new GuGu();

        IFlyBehavior roket = new RocketFly();
        IFlyBehavior nofly = new NoFly();

        duck1.setQuackBehavior(gugu);
        duck1.setFlyBehavior(roket);

        duck1.performFly();
        duck1.performSount();

        System.out.println("=====================");

        // 动态修改行为
        duck1.setQuackBehavior(guagua);
        duck1.setFlyBehavior(nofly);

        duck1.performFly();
        duck1.performSount();

        // 拓展实例
        // RPG 游戏，任务在过程中不断的打怪捡装备
        // 然后可以攻击别人，不同的武器的攻击属性不太一样


    }
}
