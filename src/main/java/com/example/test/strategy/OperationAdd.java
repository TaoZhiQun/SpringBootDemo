package com.example.test.strategy;

public class OperationAdd implements CalculateStragegy {
    @Override
    public int operation(int num1, int num2) {
        return num1 + num2;
    }
}
