package com.example.test.responsibility;

public interface A {
    default void hello(){
        System.out.println("Hello A");
    }
}
