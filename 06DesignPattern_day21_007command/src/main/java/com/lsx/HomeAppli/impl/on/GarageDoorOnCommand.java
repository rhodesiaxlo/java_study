package com.lsx.HomeAppli.impl.on;

import com.lsx.HomeAppli.GarageDoor;
import com.lsx.HomeAppli.ICommand;

public class GarageDoorOnCommand implements ICommand {
    private GarageDoor door;

    public GarageDoorOnCommand(GarageDoor door) {
        this.door = door;
    }

    public void setDoor(GarageDoor door) {
        this.door = door;
    }

    public void execute() {
        door.doorOpen();
    }
}
