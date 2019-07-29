package com.lsx;


public class DemoFabonacci {
    // 斐波那契数列示例

    public static void main(String[] args) {
        // 初始值太多，递归次数无限会导致 stackoverflowerror

        // 迭代算法的内存分析很有趣
        Long i = fabonacci(100000L);
        System.out.println("result = " + i);
    }

    public static Long fabonacci(Long n) {
        if(n==0)
            return 1L;

        if(n==1)
            return 1L;

        return fabonacci(n-1)+fabonacci(n-2);
    }
}
