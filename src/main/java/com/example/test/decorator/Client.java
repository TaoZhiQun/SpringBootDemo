package com.example.test.decorator;

public class Client {
    public static void main(String[] args) {
        Man man = new Man();
        DecoratorA decoratorA = new DecoratorA();
        DecoratorB decoratorB = new DecoratorB();
        decoratorA.setPerson(man);
        decoratorB.setPerson(decoratorA);
        decoratorB.eat();
    }

}
