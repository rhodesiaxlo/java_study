package com.lsx.domain;

public class SysException extends  Exception{
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysException(String message) {
        super(message);
    }
}
