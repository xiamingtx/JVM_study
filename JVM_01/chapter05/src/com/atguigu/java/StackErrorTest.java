package com.atguigu.java;

/**
 * 演示栈中的异常: StackOverflowError
 * @author 夏明
 * @version 1.0
 *
 * 默认情况下: count: 11420;
 * 设置栈的大小: -Xss256k 在VM options设置
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count ++ ;
        main(args);
    }
}
