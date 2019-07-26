package com.lsx;

public class DemoVarVariables {

    public static void main(String[] args) {

        System.out.println(sum(1L,2L,3L,4L));
    }

    public static long sum(long ... arr) {
        long sum =0;
        for (long l : arr) {
            sum+=l;
        }

        return sum;
    }
}
