package com.atguigu.java;

import org.junit.Test;

/**
 * @author 夏明
 * @version 1.0
 */
public class StringTest1 {
    @Test
    public void test1() {
        String s1 = "abc"; // 字面量定义的方式, "abc"存储在字符串常量池中
        String s2 = "abc"; // 实际上和上面共用同一个
        s1 = "hello";

        System.out.println(s1 == s2); // 判断地址 true  --> false

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def"; // 由于字符串的不可变性 所以其实是在常量池创建一个新的String
        System.out.println(s2); // abcdef
        System.out.println(s1); // abc
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1); // abc
        System.out.println(s2); // mbc
    }
}
