package com.lsx.HomeAppli.impl;

import com.lsx.HomeAppli.ICommand;

public class NoCommand implements ICommand {
    public void execute() {
        System.out.println("no command");
    }
}
