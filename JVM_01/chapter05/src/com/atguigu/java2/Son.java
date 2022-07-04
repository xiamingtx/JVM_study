package com.atguigu.java2;

/**
 * @author 夏明
 * @version 1.0
 */
class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father" + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class Son extends Father{
    public Son() {
        // invokespecial
        super();
    }

    public Son(int age) {
        // invokespecial
        this();
    }

    // 不是重写的父类的方法 因为静态方法不能重写
    public static void showStatic(String str) {
        System.out.println("son" + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        // invokestatic
        showStatic("atguigu.com");
        // invokestatic
        super.showStatic("good!");
        // invokespecial
        showPrivate("hello");
        // invokespecial
        super.showCommon();
        // invokevirtual 但是实际上Final的方法不能被重写 所以也认为此方法为非虚方法
        showFinal();
        // invokespecial 明确调用父类的方法
        super.showFinal();
        // 虚方法如下:
        // invokevirtual
        showCommon();
        // invokevirtual
        info();

        MethodInterface in = null;
        // invokeinterface 体现为虚方法
        in.methodA();
    }

    public void info() {

    }

    public void display(Father f) {
        f.showCommon();
    }

    public static void main(String[] args) {
        Son so = new Son();
        so.show();
    }
}

interface MethodInterface{
    void methodA();
}


