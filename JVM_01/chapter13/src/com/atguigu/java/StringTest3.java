package com.atguigu.java;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk6中:
 * -XX:PermSize=6m -XX:MaxPermSize=6m -Xms6m -Xmx6m
 * jdk8中:
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 *
 * Java 6及以前，字符串常量池存放在永久代。
 * Java 7 中oracle 的工程师对字符串池的逻辑做了很大的改变，即将字符串常量池的位置调整到Java堆内。
 * 所有的字符串都保存在堆（Heap）中，和其他普通对象一样，这样
 * 可以让你在进行调优应用时仅需要调整堆大小就可以了。
 * 字符串常量池概念原本使用得比较多，但是这个改动使得我们有足够
 * 的理由让我们重新考虑在Java 7 中使用string.intern ( )。
 * Java8元空间，字符串常量在堆
 * @author 夏明
 * @version 1.0
 */
public class StringTest3 {
    public static void main(String[] args) {
        //使用Set保持着常量池引用，避免full gc回收常量池行为
        Set<String> set = new HashSet<String>();
        //在short可以取值的范围内足以让6MB的PermSize或heap产生OOM了。
        short i = 0;
        while(true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
