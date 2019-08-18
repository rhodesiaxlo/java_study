package com.lsx.HomeAppli.impl.off;

import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.ILight;

public class KitchenLightOffCommand implements ICommand {

    private ILight kitchenLight = null;

    public void setKitchenLight(ILight kitchenLight) {
        this.kitchenLight = kitchenLight;
    }

    public KitchenLightOffCommand(ILight kitchenLight) {
        this.kitchenLight = kitchenLight;
    }

    public void execute() {
        kitchenLight.lightOff();
    }
}
