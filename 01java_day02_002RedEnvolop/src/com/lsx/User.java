package com.lsx;

public abstract class User {
    private String name;
    private Integer account;

    public void  show()
    {
        System.out.println("我叫" + this.name + ",我有" + this.account + " 元钱!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public User(String name, Integer account) {
        this.name = name;
        this.account = account;
        System.out.println("user 有参构造执行了...");

    }

    public User() {
        System.out.println("user 无参构造执行了...");
    }
}
