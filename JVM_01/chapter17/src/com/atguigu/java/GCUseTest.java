package com.atguigu.java;

import java.util.ArrayList;

/**
 *  -XX:+PrintCommandLineFlags
 *
 *  -XX:+UseSerialGC:表明新生代使用Serial GC ，同时老年代使用Serial Old GC
 *
 *  -XX:+UseParNewGC：标明新生代使用ParNew GC
 *
 *  -XX:+UseParallelGC:表明新生代使用Parallel GC    jdk8默认
 *  -XX:+UseParallelOldGC : 表明老年代使用 Parallel Old GC
 *  说明：二者可以相互激活
 *
 *  -XX:+UseConcMarkSweepGC：表明老年代使用CMS GC。同时，年轻代会触发对ParNew 的使用
 *
 *  -XX : +UseConcMarkSweepGC手动指定使用CMS收集器执行内存回收任务。
 * 开启该参数后会自动将-XX:+UseParNewGc打开。即:ParNew ( Young区用)+CMS (old区用)+serial old的组合。
 * 一XX: CMSInitiatingOccupancyFraction设置堆内存使用率的阈, 一旦达到该阈值，便开始进行回收。
 * JDK5及以前版本的默认值为68,即老年代的空间使用率达到68%时, 会执行一次CMS回收。JDK6及以上版本默认值为92%
 * 如果内存增长缓慢，则可以设置一个稍大的值，大的阈值可以有效降低CMS的触发频率，
 * 减少老年代回收的次数可以较为明显地改善应用程序性能。反之，如果应用程序内存使用率增长很快，
 * 则应该降低这个阈值，以避免频繁触发老年代串行收集器。因此通过该选项便可以有效降低Full GC的执行次数。
 *
 * -XX : +UseCMSCompactAtFul1collection用于指定在执行完FullGC后对内存空间进行压缩整理，以此避免内存碎片的产生。
 * 不过由于内存压缩整理过程无法并发执行，所带来的问题就是停顿时间变得更长了。
 * -XX:CMSFullGCsBeforeCompaction设置在执行多少次Full cC后对内存空间进行压缩整理。
 * -XX : ParallelCMSThreads设置cMS的线程数量。
 * CMs 默认启动的线程数是（ParallelGCThreads+3) / 4，
 * ParallelGCThreads 是年轻代并行收集器的线程数。
 * 当CPU资源比较紧张时，受到CMs收集器线程的影响，应用程序的性能在垃圾回收阶段可能会非常糟糕。
 *
 * @author 夏明
 * @version 1.0
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        while(true){
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
