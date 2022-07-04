package com.atguigu.java;

/**
 * 测试解释器模式和JIT编译模式
 * -Xint : 6520ms
 * -Xcomp : 950ms
 * -Xmixed : 936ms
 *
 * 自JDK10起，HotSpot又加入一个全新的即时编译器: Graal编译器。编译效果短短几年时间就追评了c2编译器。未来可期。
 * 目前，带着“实验状态"标签，需要使用开关参数
 * -XX :+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler去激活，才可以使用。
 * @author 夏明
 * @version 1.0
 */
public class IntCompTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        testPrimeNumber(1000000);

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为: " + (end - start));
    }

    public static void testPrimeNumber(int count) {
        for (int i = 0;  i < count; i++) {

            // 计算100以内的质数
            label:for(int j = 2; j <= 100; j ++ ) {
                for (int k = 2; k <= Math.sqrt(j); k ++ ) {
                    if (j % k == 0) {
                        continue label;
                    }
                }
//                System.out.println(j);
            }
        }
    }
}
