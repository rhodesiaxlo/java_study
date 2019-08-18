package com.lsx.HomeAppli.impl.off;

import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.Stero;

public class SteroOffCommand implements ICommand {
    private Stero stero;

    public void setStero(Stero stero) {
        this.stero = stero;
    }

    public SteroOffCommand(Stero stero) {
        this.stero = stero;
    }

    public void execute() {
        stero.turnOff();
    }
}
