package com.example.test.strategy;

public class OperationSub implements CalculateStragegy{
    @Override
    public int operation(int num1, int num2) {
        return num1 - num2;
    }
}
