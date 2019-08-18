package com.lsx;

import com.lsx.HomeAppli.*;
import com.lsx.HomeAppli.impl.off.BedroomLightOffCommand;
import com.lsx.HomeAppli.impl.off.GarageDoorOffCommand;
import com.lsx.HomeAppli.impl.off.KitchenLightOffCommand;
import com.lsx.HomeAppli.impl.off.SteroOffCommand;
import com.lsx.HomeAppli.impl.on.GarageDoorOnCommand;
import com.lsx.HomeAppli.impl.on.KitchenLightOnCommand;
import com.lsx.HomeAppli.impl.on.SteroOnCommand;
import org.junit.Test;

public class RemoterTest {

    @Test
    public  void remoterTest() {
        KitchenLight kl = new KitchenLight();
        GarageDoor gd = new GarageDoor();
        Stero st = new Stero();
        BedroomLight bl = new BedroomLight();


        ICommand klightOn = new KitchenLightOnCommand(kl);
        ICommand bedon = new KitchenLightOnCommand(bl);
        ICommand graon = new GarageDoorOnCommand(gd);
        ICommand steroon = new SteroOnCommand(st);

        ICommand kloff = new KitchenLightOffCommand(kl);
        ICommand boff = new BedroomLightOffCommand(bl);
        ICommand garoff = new GarageDoorOffCommand(gd);
        ICommand steroff = new SteroOffCommand(st);


        Remotor re = new Remotor();
        re.setOnCommdn(0, klightOn);
        re.setOnCommdn(1, bedon);
        re.setOnCommdn(2, graon);
        re.setOnCommdn(3, steroon);

        re.setOffCommand(0, kloff);
        re.setOffCommand(1, boff);
        re.setOffCommand(2, garoff);
        re.setOffCommand(3, steroff);

        System.out.println("------------");
        System.out.println(re);

        System.out.println("-------------");
        re.onButtonPressed(3);
        re.onButtonPressed(2);
        re.onButtonPressed(1);

        re.OffButton(1);
        re.OffButton(2);
        re.OffButton(3);



    }
}
