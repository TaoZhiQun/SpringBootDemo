package com.example.test.decorator;

public class Client {
    public static void main(String[] args) {
        Component component = new Concrete();
        final ConcreteDecorator concreteDecorator = new ConcreteDecorator(component);
        concreteDecorator.function();
    }
}
