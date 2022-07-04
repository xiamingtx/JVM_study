package com.atguigu.java2;

/**
 * jdk1.6中，将这个字符串对象尝试放入串池。
 * 如果串池中有，则并不会放入。返回已有的串池中的对象的地址
 * 如果没有，会把此对象复制一份，放入串池，并返回串池中的对象地址
 * Jdk1.7起，将这个字符串对象尝试放入串池。
 * 如果串池中有，则并不会放入。返回已有的串池中的对象的地址
 * 如果没有，则会把对象的引用地址复制一份，放入串池，并返回串池中的引用地址
 * @author 夏明
 * @version 1.0
 */
public class StringIntern1 {
    public static void main(String[] args) {
        //StringIntern.java中练习的拓展：
        String s3 = new String("1") + new String("1");//new String("11")
        //执行完上一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
        String s4 = "11";//在字符串常量池中生成对象"11"
        String s5 = s3.intern();
        System.out.println(s3 == s4);//false
        System.out.println(s5 == s4);//true
    }
}
