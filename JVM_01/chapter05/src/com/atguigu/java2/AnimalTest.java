package com.atguigu.java2;

/**
 * 说明早期绑定和晚期绑定的例子
 * 静态方法、私有方法、final方法、实例构造器、父类方法都是非虚方法。
 * 其他方法称为虚方法
 * @author 夏明
 * @version 1.0
 */
class Animal {
    public void eat() {
        System.out.println("动物进食");
    }
}
interface Huntable{
    void hunt();
}

class Dog extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子, 多管闲事");
    }
}

class Cat extends Animal implements Huntable {

    public Cat() {
        super(); // 表现为早期绑定
    }

    public Cat(String name) {
        this(); // 表现为早期绑定
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("猫吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子, 天经地义");
    }
}

public class AnimalTest {
    public void showAnimal(Animal animal) {
        animal.eat(); // 表现为, 晚期绑定
    }
    public void showHunt(Huntable h) {
        h.hunt(); // 表现为, 晚期绑定
    }
}


