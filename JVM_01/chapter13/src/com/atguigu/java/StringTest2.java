package com.atguigu.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 默认 -XX:StringTableSize=1009
 *
 * string的string Pool是一个固定大小的Hashtable，默认值大小长度是1009。如果放进string Pool的string非常多，就会造成Hash冲突严重，从而导致链表会很长，而链表长了后直接会造成的影响就是当调用string.intern时性能会大幅下降。
 * 使用-xx : StringTableSize可设置stringTable的长度
 * 在jdk6中stringTable是固定的，就是1009的长度，所以如果常量池中的字符串过多就会导致效率下降很快。
 * StringTableSize设置没有要求在jdk7中，StringTable的长度默认值是60013
 * Jdk8开始，设置StringTable的长度的话，1009是可设置的最小值T
 * @author 夏明
 * @version 1.0
 */
public class StringTest2 {
    public static void main(String[] args) {
        //测试StringTableSize参数
//        System.out.println("我来打个酱油");
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while((data = br.readLine()) != null){
                data.intern(); //如果字符串常量池中没有对应data的字符串的话，则在常量池中生成
            }

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (end - start));//1009:143ms  100009:47ms
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}