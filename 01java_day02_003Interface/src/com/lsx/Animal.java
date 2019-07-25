package com.lsx;

public interface Animal {

    public  static final String i = "aaaaaa";
    void sound();
    void swim();
    void eat();

    default  void newBehaviour()
    {
        System.out.println(i);
        System.out.println("暂时不知道些什么，占个坑再说");
    }

    public static void staticMethod()
    {
        System.out.println("静态方法");
    }

    public default  void default1()
    {
        System.out.println("公有方法1");
        // common();
    }

    public default  void default2()
    {
        System.out.println("公有方法2");
        //common();
    }

//    private void common()
//    {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
}
