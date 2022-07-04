package com.atguigu.java3;

/**
 * 何为线程安全?
 *      如果只有一个线程才可以操作此数据, 则必是线程安全的。
 *      如果有多个线程操作此数据, 则此数据是共享数据, 则不考虑同步机制的话, 会存在线程安全问题
 * @author 夏明
 * @version 1.0
 */
public class StringBuilderTest {

    int num = 10;

    // s1的声明方式是线程安全的
    public static void method1() {
        // StringBuilder线程不安全
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        // ...
    }
    // sBuilder的操作过程, 是线程不安全的
    public static void method2(StringBuilder sBuilder) {
        sBuilder.append("a");
        sBuilder.append("b");
        // ...
    }
    // s1的操作: 是线程不安全的 method1的s1在执行完成后就在内部消亡了 但是method3中返回出去了
    public static StringBuilder method3() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1;
    }
    // s1的操作: 是线程安全的 s1实际上在内部消亡了 和第一种情况类似 这时候是new一个String返回了
    // 所以返回的String可能不安全 但是s1是安全的
    public static String method4() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1.toString();
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();

        new Thread(() -> {
            s.append("a");
            s.append("b");
        }).start();

        method2(s);
    }
}
