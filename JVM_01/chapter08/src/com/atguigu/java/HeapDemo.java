package com.atguigu.java;

/**
 * -Xms10m -Xmx10m
 * 每一个JVM实例(一个进程)都对应一个唯一的堆
 * 所有的线程共享堆, 在这里还可以划分线程私有的缓冲区(Thread Local Allocation Buffer, TLAB)。 否则并发性就太差了
 * 堆在物理上可以不连续 但是在逻辑上应该被视为连续的
 * 所有的对象实例和数组都应该在运行时被分配到堆上
 * 数组和对象可能永远都不会存储在栈上, 因为栈帧中保存引用, 这个引用指向对象和数组在堆中的位置
 * 在方法结束后, 堆中的对象不会马上移除, 仅仅在垃圾收集的时候才会被移除
 *
 * 堆是垃圾回收(GC)的重要区域
 *
 * jdk7之前: 新生区 + 养老区 + 永久区
 * jdk8及之后: 新生区 + 养老区 + 元空间
 * 约定 新生区 <=> 新生代 <=> 年轻代  养老区 <=> 老年区 <=> 老年代  永久区 <=> 永久代
 *
 * @author 夏明
 * @version 1.0
 */
public class HeapDemo {
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
