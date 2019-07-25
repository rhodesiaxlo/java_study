package com.lsx;

import java.util.ArrayList;

public class Manager extends  User{

    public Manager(String name, Integer account) {
        super(name, account);
        System.out.println("manager 有参构造执行了...");

    }

    public Manager() {
        System.out.println("manager 无参构造执行了...");

    }

    /**
     * 发红包
     * @param money
     * @param count
     * @return
     */
    public ArrayList<Integer> send(int money, int count)
    {
        ArrayList<Integer> redList = new ArrayList<>();

        // 获得当前金额
        if(this.getAccount() < money)
        {
            System.out.println("金额不足");
            return null;
        }

        this.setAccount(this.getAccount()-money);

        // 分钱
        Integer avg = money/count;
        Integer mod = money%count;

        for (int i = 0; i < count-1; i++) {
            redList.add(avg);
        }

        // 最后一份增加零头
        redList.add(avg+mod);

        return redList;
    }
}
