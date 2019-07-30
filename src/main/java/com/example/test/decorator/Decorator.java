package com.example.test.decorator;

public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void function() {
        component.function();
    }
}
