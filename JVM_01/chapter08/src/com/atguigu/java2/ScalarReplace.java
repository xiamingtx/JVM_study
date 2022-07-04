package com.atguigu.java2;

/**
 * 标量替换测试
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * @author 夏明
 * @version 1.0
 */
public class ScalarReplace {
    public static class User {
        public int id;
        public String name;
    }

    public static void alloc() {
        User u = new User(); // 未发生逃逸 可以替换成标量
        u.id = 5;
        u.name = "www.atguigu.com";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i ++ ) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为: " + (end - start) + " ms");
    }
}

/**
*
* class Customer {
*   String name;
*   int id;
*   Account acount;
* }
 *
 * class Account {
 *
 * }
*/