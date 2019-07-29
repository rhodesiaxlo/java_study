package com.lsx;

import java.io.FileNotFoundException;

public class DemoException {
    public static void main(String[] args) {
        // 知识点1 异常
        // 运行期异常无需处理  nullpointexception
        //                    cast
        //                    illegalargument
        //                    indexoutofbound
        //                    divide by 0
        // 编译器异常  需要处理

        // 知识点2
        // 异常处理的2中方式 throws 交给jvm ,中断执行
        //                   try {} catch{} 后续代码可以继续执行

        // 知识点3
        // 多异常的捕获方式


        // 知识点3
        // try { } catch {} finally {} 的执行顺序
//        try {
//            readFile("c:\\11.txt");
//        } catch (FileNotFoundException e) {
//            System.out.println("exception...");
//            e.printStackTrace();
//        }finally {
//            System.out.println();
//            System.out.println("finally...");
//        }
//
//        System.out.println("return...");

        // 知识点4
        // 重写父类方法，照样抛出异常
        // 重写父类方法，抛出自异常
        // 重写父类方法，不抛出异常
        // 父类方法没有抛出异常，子类不能抛出异常
        // ????? 真碰到异常怎么办，try catch

        // 知识点5
        // 自定义exception
        // 继承自 Exception RuntimeException
        // 需要重写空参构造和全参构造

        Zi z = new Zi();
        z.method4();

    }

    public static void readFile(String filename) throws FileNotFoundException {


        if(!filename.equals("c:\\1.txt")) {
            throw new  FileNotFoundException("file not found");
        }

        System.out.println("后续代码");
    }
}
