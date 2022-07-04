package com.atguigu.java2;

/**
 * 枝上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails  不开启逃逸分析
 * 如果-XX:+DoEscapeAnalysis开启逃逸分析 就会采用栈上优化 执行速度变快 同时在栈上也不会发生gc
 * @author 夏明
 * @version 1.0
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i ++ ) {
            alloc();
        }
        // 查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费时间为: " + (end - start) + "ms");

        // 为了方便查看堆中对象个数, 线程sleep
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User(); // 未发生逃逸
    }

    static class User {

    }
}
