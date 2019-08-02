package com.lsx;

import org.junit.Test;

import javax.print.attribute.standard.PresentationDirection;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.transform.Source;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoLambda {
    public static void main(String[] args) {
        // 常用的函数式编程接口

        // ???????????????????????????????????
        // ???????????????????????????????????
        // ！！！未完结 还有方法引用没有学习
    }



    @Test
    public void lambdaAsReturn() {

    }

    @Test
    public void lambdaSupplier() {
        supplierImpl(()->"12345");
    }

    @Test
    public void lambdaConsumper() {
        // consumer 中不止一个接口，但是只有一个抽象接口，所以还是函数式接阔

        consumerImpl("赵丽颖", (String s)->{
            System.out.println(new StringBuffer(s).reverse().toString());
        });
    }

    @Test
    public void lambdaPredicate() {
        predicateImpl("鲁仕鑫", s->s.length()==3);
    }

    @Test
    public void andTest() {
        System.out.println( " and test = "   +      predicateAndImpl("鲁仕鑫",s->s.length()==3, s->s.contains("张")));
    }

    @Test
    public void orTest() {
        System.out.println(  "or test = "  +     predicateOrImpl("鲁仕鑫",s->s.length()==3, s->s.contains("张")));

    }

    public void functionTest() {

    }


    public Comparator<String> returnComp() {
        return (String s1, String s2)->s1.length()-s2.length();
    }

    public void supplierImpl(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    public void consumerImpl(String targe, Consumer<String> con) {
        con.accept(targe);
    }

    public void predicateImpl(String targe, Predicate<String> p) {
        System.out.println(p.test(targe));
    }

    public boolean predicateAndImpl(String target, Predicate<String> p1, Predicate<String> p2) {
        //return p1.test(target) && p2.test(target);

        return p1.and(p2).test(target);
    }

    public boolean predicateOrImpl(String target, Predicate<String> p1, Predicate<String> p2) {
        return p1.or(p2).test(target);
    }

    public void functionImpl() {

    }


}
