package com.example.test.responsibility;

public interface B  extends A{
    default void hello(){
        System.out.println("Hello B");
    }

}
