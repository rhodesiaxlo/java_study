package com.lsx.HomeAppli;

import com.lsx.HomeAppli.impl.NoCommand;

import java.util.Arrays;

public class Remotor {
    ICommand[] onCommands;
    ICommand[] offCommands;

    public Remotor() {
        onCommands = new ICommand[7];
        offCommands = new ICommand[7];

        for (int i = 0; i < 7; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();

        }
    }

    public Remotor(ICommand[] onCommands, ICommand[] offCommands) {
        this.onCommands = onCommands;
        this.offCommands = offCommands;
    }

    public void setOnCommands(ICommand[] onCommands) {
        this.onCommands = onCommands;
    }

    public void setOffCommands(ICommand[] offCommands) {
        this.offCommands = offCommands;
    }

    public  void onButtonPressed(Integer slotindex) {
        onCommands[slotindex].execute();
    }

    public void OffButton(Integer slotindex) {
        offCommands[slotindex].execute();
    }

    public  void setOnCommdn(Integer i , ICommand cmd) {
        onCommands[i] = cmd;
    }

    public void setOffCommand(Integer i, ICommand cmd) {
        offCommands[i] = cmd;
    }

    @Override
    public String toString() {
        return "Remotor{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
