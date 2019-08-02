package com.lsx;

import org.junit.Test;

public class DemoLambda {
    public static void main(String[] args) {
        // 延迟lambda 的延迟执行

        // 同  override  serialization 一样
        // functionalinterface 也是一个函数式接口的标识注解没有实际意义
    }

    @Test
    public void delayTest() {
        String s1 = "hello";
        String s2 = "world";
        String targe = s1 + s2;

        log(1, s1+s2);

    }

    @Test
    public void delayTest2() {
        String s1 = "hello";
        String s2 = "world";

        log2(1, ()-> System.out.println(s1+s2));
    }


    public void log(Integer level, String strS) {
        if(level==1)
            System.out.println(strS);
    }

    public void log2(Integer level, ShowMessage sm)
    {
        if(level==1) {
            System.out.println("1234");
            sm.show();
        }

    }


}
