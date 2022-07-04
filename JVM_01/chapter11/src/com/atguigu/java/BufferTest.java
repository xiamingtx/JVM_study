package com.atguigu.java;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 *
 * IO       NIO(New IO / Non-Blocking IO)
 * byte[] / char[]  Buffer
 * Stream           Channel
 *
 * 查看直接内存的占用与释放
 * @author 夏明
 * @version 1.0
 */
public class BufferTest {
    private static final int BUFFER = 1024 * 1024 * 1024; // 1GB

    public static void main(String[] args) {
        // 直接分配本地的内存空间
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕, 请求指示! ");

        Scanner scanner = new Scanner(System.in);
        scanner.next(); // 阻塞

        System.out.println("直接内存开始释放! ");
        byteBuffer = null;
        System.gc();

        scanner.next(); // 阻塞
    }
}
