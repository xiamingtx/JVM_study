package com.atguigu.java;

/**
 * @author 夏明
 * @version 1.0
 */
public class StackStruTest {
    public static void main(String[] args) {
        // int i = 2 + 3;
        // javap -v .\StackStruTest.class 进行反编译
        int i = 2;
        int j = 3;
        int k = i + j;

        // jps 打印正在执行的进程
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
