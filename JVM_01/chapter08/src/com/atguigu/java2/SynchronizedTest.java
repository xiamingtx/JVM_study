package com.atguigu.java2;

/**
 * 同步省略说明
 * 在字节码文件中仍然可以看到同步的声明 但是在运行的时候JVM会对于逃逸分析进行同步省略优化
 * @author 夏明
 * @version 1.0
 */
public class SynchronizedTest {
    public void f() {
        Object hollis = new Object();
        synchronized(hollis) {
            System.out.println(hollis);
        }
    }
}
