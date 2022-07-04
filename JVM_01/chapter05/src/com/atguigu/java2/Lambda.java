package com.atguigu.java2;

/**
 * 体会invokedynamic指令
 * @author 夏明
 * @version 1.0
 */
@FunctionalInterface
interface Func {
    public boolean func(String str);
}

public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        // 在生成接口类对象的时候使用lambda表达式 lambda表达式使得作为静态语言的java拥有了一些动态语言特性
        // invokedynamic
        Func func = s -> {
            return true;
        };

        lambda.lambda(func);

        lambda.lambda(s -> {
            return true;
        });
    }
}
