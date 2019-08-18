package com.lsx.HomeAppli.impl.on;


import com.lsx.HomeAppli.BedroomLight;
import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.ILight;

public class BedroomLightOnCommand implements ICommand {

    private ILight light;

    public void setLight(BedroomLight light) {
        this.light = light;
    }

    public BedroomLightOnCommand(BedroomLight light) {
        this.light = light;
    }

    public void execute() {
        light.lightOn();
    }
}
