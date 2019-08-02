package com.lsx;

public class Person {

    public String publicName;
    protected String protestName;
    String defaultName;
    private  String privateName;

    public static String publicName2;
    protected  static String protestName2;
    static String defaultName2;
    private  static  String privateName2;

    public void method1()
    {}

    public static void staticMethod1() {

    }

    public Person(String publicName) {
        this.publicName = publicName;
    }

    public Person() {
    }

    public void show(String msg) {
        System.out.println(msg);
    }

    @Override
    public String toString() {
        return "Person{" +
                "publicName='" + publicName + '\'' +
                ", protestName='" + protestName + '\'' +
                ", defaultName='" + defaultName + '\'' +
                ", privateName='" + privateName + '\'' +
                '}';
    }
}
