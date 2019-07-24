package com.lsx;

public class NewPhone extends OldPhone{
    @Override
    public void show() {
        super.show();
        System.out.println("头像");
        System.out.println("姓名");
        method2();
        this.method2();
    }

    public NewPhone() {
        // super must be the first statement
        // 构造方法只能被构造方法调用
        System.out.println("new phone 构造方法...");

    }

    public void method2()
    {
        System.out.println("类内部方法调用");
    }
}
