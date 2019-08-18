package com.lsx.HomeAppli.impl.on;

import com.lsx.HomeAppli.ICommand;
import com.lsx.HomeAppli.Stero;

public class SteroOnCommand implements ICommand {
    private Stero stero;

    public void setStero(Stero stero) {
        this.stero = stero;
    }

    public SteroOnCommand(Stero stero) {
        this.stero = stero;
    }

    public void execute() {
        stero.turnOn();
    }
}
