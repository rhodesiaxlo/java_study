package com.lsx.HomeAppli.impl.off;


import com.lsx.HomeAppli.BedroomLight;
import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.ILight;

public class BedroomLightOffCommand implements ICommand {

    private ILight light;

    public void setLight(BedroomLight light) {
        this.light = light;
    }

    public BedroomLightOffCommand(BedroomLight light) {
        this.light = light;
    }

    public void execute() {
        light.lightOff();
    }
}
