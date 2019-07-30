package com.example.test.proxy;

public class RealSubject implements Subject {
    @Override
    public void operate() {
        System.out.println("real subject operate");
    }
}
