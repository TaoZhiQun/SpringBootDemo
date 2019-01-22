package com.example.test.decorator;



public class DecoratorA extends Decorator{
    @Override
    public void eat() {
        super.eat();
        System.out.println("装饰者A:再吃一顿饭");
    }
}
