package com.example.test.strategy;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        System.out.println("数字校验执行");
        return s.matches("\\d+");
    }
}
