package com.atguigu.java;

/**
 * @author 夏明
 * @version 1.0
 */
public class IHaveNatives {
    public native void Native1(int x);

    public native static long Native2();

    private native synchronized float Native3(Object o);

    native void Native4(int[] ary) throws Exception;
}
