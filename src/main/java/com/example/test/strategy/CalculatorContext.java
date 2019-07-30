package com.example.test.strategy;

public class CalculatorContext {
    private CalculateStragegy calculateStragegy;

    public CalculatorContext(CalculateStragegy calculateStragegy) {
        this.calculateStragegy = calculateStragegy;
    }

    public int executeStrategy(int num1, int num2) {
        return calculateStragegy.operation(num1, num2);
    }
}
