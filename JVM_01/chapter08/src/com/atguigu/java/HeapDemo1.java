package com.atguigu.java;

/**
 * -Xms20m -Xmx20m
 * @author 夏明
 * @version 1.0
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start.......");
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end.........");
    }
}
