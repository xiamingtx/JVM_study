package java1;

/**
 * -Xms600m -Xmx600m
 *
 * -NewRatio: 设置新生代与老年代的比例。默认值是2(老年代 / 新生代)
 * 默认-XX:NewRatio=2
 * Eden与Survivor比例 -SurvivorRatio 默认8 : 1 : 1(但是实际上默认跑起来是6 : 1 : 1) 默认值是8
 * 要想使用这个默认值就要指定一下-XX:SurvivorRatio=8
 *
 * -XX: -UseAdaptiveSizePolicy :关闭自适应的内存分配策略(暂时用不到)
 *
 * 几乎所有对象都是在Eden区被new出来的, 绝大部分的Java对象的销毁都在新生代中进行
 * 可以使用选项-Xmn:设置新生代的初始大小 这个参数一般使用默认值即可(一般不设置)
 *
 * 针对幸存者s0,s1区的总结:复制之后有交换，谁空谁是to.
 * 关于垃圾回收:频繁在新生区收集，很少在养老区收集，几乎不在永久区/元空间收集。
 *
 * @author 夏明
 * @version 1.0
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 * @author 夏明
 * @date 2022/5/29 19:44
 * @param null
 * 对象分配过程∶概述
 * 为新对象分配内存是一件非常严谨和复杂的任务，JVM的设计者们不仅需要考虑内存如何分配、在哪里分配等问题，
 * 并且由于内存分配算法与内存回收算法密切相关，所以还需要考虑GC执行完内存回收后是否会在内存空间中产生内存碎片。
 * 1. new的对象先放伊甸园区。此区有大小限制。
 * 2．当伊甸园的空间填满时，程序又需要创建对象，JVM的垃圾回收器将对伊甸园区进行垃圾回收(Minor GC)，
 * 将伊甸园区中的不再被其他对象所引用的对象进行销毁。再加载新的对象放到伊甸园区
 * 3．然后将伊甸园中的剩余对象移动到幸存者0区。
 * 4．如果再次触发垃圾回收，此时上次幸存下来的放到幸存者0区的，如果没有回收，就会放到幸存者1区。
 * 5．如果再次经历垃圾回收，此时会重新放回幸存者0区，接着再去幸存者1区。
 * 6．啥时候能去养老区呢?可以设置次数。默认是15次。
 * ·可以设置参数:-XX:MaxTenuringThreshold=<N>进行设置。
 */
