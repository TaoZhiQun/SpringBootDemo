package com.example.test.decorator;

public class Concrete implements Component {
    @Override
    public void function() {
        System.out.println("基本功能：呼吸+觅食+睡觉");
    }
}
