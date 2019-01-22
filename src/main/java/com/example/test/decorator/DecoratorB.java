package com.example.test.decorator;

public class DecoratorB extends Decorator {
    @Override
    public void eat() {
        super.eat();
        System.out.println("装饰者B：再喝一碗汤");
    }
}
