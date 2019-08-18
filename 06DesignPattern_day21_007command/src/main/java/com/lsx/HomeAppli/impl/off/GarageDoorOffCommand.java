package com.lsx.HomeAppli.impl.off;

import com.lsx.HomeAppli.GarageDoor;
import com.lsx.HomeAppli.ICommand;

public class GarageDoorOffCommand implements ICommand {
    private GarageDoor door;

    public GarageDoorOffCommand(GarageDoor door) {
        this.door = door;
    }

    public void setDoor(GarageDoor door) {
        this.door = door;
    }

    public void execute() {
        door.doorClose();
    }
}
