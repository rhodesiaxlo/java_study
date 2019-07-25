package com;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class lsx {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int j = 0; j <  100000000; j++) {
            sum +=j;
        }

        System.out.println("1 亿次打印操作耗时:" + (System.currentTimeMillis()-start));
        // 1 亿次打印操作耗时:517140  500 多秒
        // 1 亿次数学运算是 46 毫秒，执行效率是 1000倍

        // system 的第二个
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {11,22,33,44,55,66,77};
        int[] arr3 = {111,222,333};

        System.out.println("复制前" + Arrays.toString(arr2));
        System.arraycopy(arr, 0, arr2,0,3);
        System.out.println("复制后" + Arrays.toString(arr2));


        System.out.println("复制前" + Arrays.toString(arr3));
        System.arraycopy(arr, 0, arr3,0,5);
        System.out.println("复制后" + Arrays.toString(arr3));




    }
}
