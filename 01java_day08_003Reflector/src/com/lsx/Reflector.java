package com.lsx;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflector {
    public static void main(String[] args) {
        // 反射的学习

        // 源代码  类对象 运行时

        // 获取类对象的3中方式 Class.forName("全类名")  (源代码)
        // .class （类对象)
        // .getClass 运行（对象阶段)


        // getField getFields (公有)
        // getDeclaredFields  getDeclaredField(所有的）

        // getMethod getMethods
        // getDeclaredMethod getDeclaredMethods

        // getConstructor getConstructors
        // getDeclaredConstructor getDeclaredConstructor


    }

    @Test
    /**
     * 获取类对象的第一种方式 class.forName(全类名)
     */
    public void getClass1() {
        try {
            Class cls = Class.forName("com.lsx.Person");
            System.out.println(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    /**
     * 获取类对象的第二种方式
     * class
     */
    public void getClass2() {
        Class cls = Person.class;
        System.out.println(cls);
    }

    @Test
    public void getClass3() {
        Person p = new Person();
        Class  cls = p.getClass();
        System.out.println(cls);
    }

    @Test
    /**
     * 对比三种类对象的获取方式得到的是同一个对象
     */
    public void classEqual()
    {
        Class cls1 = null;
        try {
            cls1 = Class.forName("com.lsx.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class cls2 = Person.class;
        Class cls3 = new Person().getClass();

        System.out.println(cls1==cls2);
        System.out.println(cls3==cls2);
    }

    @Test
    public void getFields() {
        Class cls = Person.class;
        Field[] fields = cls.getDeclaredFields();

        System.out.println("declared ==================");
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("public =====================");
        for (Field fld : cls.getFields()) {
            System.out.println(fld);
        }

    }

    @Test
    public void getMethod() {
        Class cls = Person.class;
        System.out.println(" declard method ===================");
        for (Field method : cls.getDeclaredFields()) {
            System.out.println(method);
        }

        System.out.println(" public ============================");
        for (Method method2 : cls.getMethods()) {
            System.out.println(method2);
        }
    }

    @Test
    public void getConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cls = Person.class;
        Constructor con1 = null;
        Constructor con2 = null;
        //Constructor con3 = Person.class.newInstance();

        try {
            con1 = cls.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            con2 = cls.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(con1==con2);

        System.out.println(con1.newInstance());
        System.out.println(con2.newInstance("鲁仕鑫"));
    }

    @Test
    public void invoke() {
        try {
            Method toString = Person.class.getMethod("show", String.class);
            System.out.println("=============================================");
            toString.invoke(Person.class.newInstance(), "1234");
            System.out.println("=============================================");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }



}
