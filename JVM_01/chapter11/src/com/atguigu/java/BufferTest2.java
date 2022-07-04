package com.atguigu.java;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * 本地内存的OOM:  OutOfMemoryError: Direct buffer memory
 *
 * 1.也可能导致OutOfMemoryError异常
 * 2.由于直接内存在Java堆外，因此它的大小不会直接受限于-Xmx指定的最大堆大小，但是系统内存是有限的，Java堆和直接内存的总和依然受限于操作系统能给出的最大内存。
 * 3.缺点
 *  [1]分配回收成本较高
 *  [2]不受JVM内存回收管理
 * 4.直接内存大小可以通过MaxDirectMemorySize设置
 * 5.如果不指定，默认与堆的最大值-xmx参数值一致
 *
 * @author 夏明
 * @version 1.0
 */
public class BufferTest2 {
    private static final int BUFFER = 1024 * 1024 * 20;//20MB

    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<>();

        int count = 0;
        try {
            while(true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
                list.add(byteBuffer);
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println(count);
        }
    }
}
