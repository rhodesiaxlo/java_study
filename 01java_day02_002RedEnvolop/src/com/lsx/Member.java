package com.lsx;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{

    public Member(String name, Integer account) {
        super(name, account);
    }

    public Member() {
    }

    /**
     * 收红包
     * @param money
     */
    public void receive(ArrayList<Integer> redList)
    {
        if(redList.size()==0)
        {
            System.out.println("红包已拍完！！");
            return;
        }
        Random r = new Random();

        // 基本类型和引用类型不兼容的地方
        // Integer index = r.nextInt(redList.size());
        int index = r.nextInt(redList.size());
        Integer money = redList.remove(index);

        this.setAccount(this.getAccount() +money);
    }
}
