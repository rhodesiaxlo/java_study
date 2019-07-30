package com.lsx;

public class OOPTest {
    public static void main(String[] args) {
        // 情况1 父子含有相同的成员变量，调用规则是什么
        System.out.println("=====================");
        Fu f1 = new Fu();
        Zi z1 = new Zi();
        System.out.println(f1.var1); // fu
        System.out.println(z1.var1); // zi

        // 情况2 不同的方法访问相同的变量，方法属于谁，使用税的本类变量
        System.out.println("=====================");
        f1.fuMethod(); // fu
        z1.methodZi(); // zi

        // 情况3，继续第二种情况，父类或者局部变量怎么办
        System.out.println("=====================");
        z1.methodZiScope(); // local
                            // zi
                            // fu

        System.out.println("=====================");
        // 多态  父类的指针条用子类的方法
        Fu f2   = new Zi();
        f2.method();
        System.out.println("=====================");

        // 伪代码实现
        OldPhone ol  = new OldPhone();
        NewPhone np = new NewPhone();

        ol.show();
        np.show();

        // gc 对象的生命周期

        // super 和 this 都需要first staement

        // 子类对象的构造顺序
    }
}
