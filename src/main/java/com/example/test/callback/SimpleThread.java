package com.example.test.callback;

public class SimpleThread extends ThreadHolder {
    @Override
    public void run() {
        System.out.println("do something");
    }
}
