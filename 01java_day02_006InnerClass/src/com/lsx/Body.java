package com.lsx;

public class Body {

    public class Heart {

        public void heartMethod()
        {
            System.out.println("心脏跳动:砰砰砰");
            // 可以直接访问外部类的成员变量
            System.out.println("我叫" + name);
        }
    }

    private String name;

    public void bodyMethod()
    {
        System.out.println("body method");

        Heart h = new Heart();
        h.heartMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
