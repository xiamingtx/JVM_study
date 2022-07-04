package com.atguigu.java3;

/**
 * string的垃圾回收:
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 * @author 夏明
 * @version 1.0
 */
public class StringGCTest {
    public static void main(String[] args) {
        for (int j = 0; j < 1000000; j ++ ) {
            String.valueOf(j).intern();
        }
    }
}
