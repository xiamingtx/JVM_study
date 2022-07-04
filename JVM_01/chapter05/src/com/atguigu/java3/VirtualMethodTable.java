package com.atguigu.java3;

/**
 * @author 夏明
 * @version 1.0
 */
interface Friendly {
    void sayHello();
    void sayGoodbye();
}

class Dog {
    public void sayHello() {

    }
    public String toString() {
        return "Dog";
    }
}

class Cat implements Friendly {
    public void eat() {

    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }
    protected void finalize() {

    }
    public String toString() {
        return "Cat";
    }
}

class CockerSpaniel extends Dog implements Friendly {
    public void sayHello() {
        super.sayHello();
    }
    @Override
    public void sayGoodbye() {

    }
}

public class VirtualMethodTable {
}
