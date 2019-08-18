package com.lsx.HomeAppli.impl.on;

import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.ILight;

public class KitchenLightOnCommand implements ICommand {

    private ILight kitchenLight = null;

    public void setKitchenLight(ILight kitchenLight) {
        this.kitchenLight = kitchenLight;
    }

    public KitchenLightOnCommand(ILight kitchenLight) {
        this.kitchenLight = kitchenLight;
    }

    public void execute() {
        kitchenLight.lightOn();
    }
}
