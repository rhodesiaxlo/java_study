package com.lsx;

import java.util.Random;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        // 0 ~ 99
        int test = r.nextInt(100);
        int attmp = 0;
        while(attmp<5)
        {
            // 猜数字
            System.out.println("请输入与一个整数");
            int in = sc.nextInt();
            if( in >test ) {
                System.out.println(" 目标数字比 " + in + " 小");
            } else if (in < test) {
                System.out.println(" 目标数字比 " + in + " 大");
            }else{
                System.out.println(" 恭喜你答对了 ，正确数字是 " + in);
                break;
            }

            attmp++;
        }

        if(attmp >=5)
        {
            System.out.println(" 很遗憾，你的次数已经用完");
        }

    }
}
