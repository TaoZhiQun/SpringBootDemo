package com.example.test.factory;

public class SportFactory implements IFactory {
    @Override
    public ICar createCar() {
        return new SportCar();
    }
}
