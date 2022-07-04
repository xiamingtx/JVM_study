package com.atguigu.java;

/**
 * 《Java虚拟机规范》中明确说明:"尽管所有的方法区在逻辑上是属于堆的一部分，
 *  但一些简单的实现可能不会选择去进行垃圾收集或者进行压缩。”但对于HotSpotJVM而言，
 *  方法区还有一个别名叫做Non-Heap(非堆)，目的就是要和堆分开。
 *
 *  所以，方法区看作是一块独立于Java堆的内存空间。
 *
 *  方法区的基本理解
 *
 *  1.方法区（Method Area）与Java堆一样，是各个线程共享的内存区域。
 *  2.方法区在JVM启动的时候被创建，并且它的实际的物理内存空间中和Java堆区一样都可以是不连续的。
 *  3.方法区的大小，跟堆空间一样，可以选择固定大小或者可扩展。
 *  4.方法区的大小决定了系统可以保存多少个类，如果系统定义了太多的类，导致方法区溢出，虚拟机同样会抛出内存溢出错误:
 *  java.lang. outOfMemoryError: PermGen space 或者java.lang.OutOfMemoryError: Metaspace
 *      [1] 加载大量的第三方的jar包 [2] Tomcat部署的工程过多(30-50个) [3] 大量动态的生成反射类
 *  5.关闭JVM就会释放这个区域的内存。
 *
 *
 *  HotSpot中方法区的演进
 *
 * 1.本质上，方法区和永久代并不等价。仅是对hotspot而言的。《Java虚拟机规范》对如何实现方法区，不做统一要求。例如:BEA JRockit/ IBM J9中不存在永久代的概念。
 * 2.现在来看，当年使用永久代，不是好的idea。导致Java程序更容易ooM(超过-XX:MaxPermSize上限)
 * 3.而到了JDK 8，终于完全废弃了永久代的概念，改用与JRockit、J9一样在本地内存中实现的元空间（Metaspace)来代替
 * 4.元空间的本质和永久代类似，都是对JVM规范中方法区的实现。不过元空间与永久代最大的区别在于:元空间不在虚拟机设置的内存中，而是使用本地内存。
 * 5.永久代、元空间二者并不只是名字变了，内部结构也调整了。
 * 6.根据《Java虚拟机规范》的规定，如果方法区无法满足新的内存分配需求时，将抛出OOM异常。
 * @author 夏明
 * @date 2022/5/30 19:17
 * @param null
 */

/**
 *
 * 测试设置方法区大小参数的默认值
 *
 * 方法区的大小不必是固定的，jvm可以根据应用的需要动态调整。
 * jdk7及以前:
 *  1.通过-XX:PermSize来设置永久代初始分配空间。默认值是20.75M
 *  2.-XX:MaxPermSize来设定永久代最大可分配空间。32位机器默认是64M,64位机器模式是82M
 *  3.当JVM加载的类信息容量超过了这个值，会报异常OutOfMemoryError: PermGen space
 *
 *  jdk8及以后:
 * 1.元数据区大小可以使用参数-XX:MetaspaceSize和-XX:MaxMetaspaceSize指定,替代上述原有的两个参数。
 * 默认值依赖于平台。windows下，-XX:MetaspaceSize是21M，-XX:MaxMetaspaceSize 的值是-1，即没有限制。
 * 2.与永久代不同，如果不指定大小，默认情况下，虚拟机会耗尽所有的可用系统内存。
 * 如果元数据区发生溢出，虚拟机一样会抛出异常OutOfMemoryError: Metaspace
 * 3.-XX:MetaspaceSize:设置初始的元空间大小。对于一个64位的服务器端JVM来说，其默认的-XX:MetaspaceSize值为21MB。
 * 这就是初始的高水位线，一旦触及这个水位线，Full GC将会被触发并卸载没用的类（即这些类对应的类加载器不再存活),
 * 然后这个高水位线将会重置。新的高水位线的值取决于GC后释放了多少元空间。如果释放的空间不足，
 * 那么在不超过MaxMetaspaceSize时，适当提高该值。如果释放空间过多，则适当降低该值。
 * 4.如果初始化的高水位线设置过低，上述高水位线调整情况会发生很多次。通过垃圾回收器的日志可以观察到Full GC多次调用。
 * 为了避免频繁地GC，建议将-XX: MetaspaceSize设置为一个相对较高的值。
 *
 * @author 夏明
 * @version 1.0
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start......");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end.......");
    }
}
