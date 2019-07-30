package com.example.test.strategy;

public class Client {
    public static void main(String[] args) {
        int a =4,b=2;
        CalculatorContext calculatorContext = new CalculatorContext(new OperationAdd());
        System.out.println(calculatorContext.executeStrategy(a,b));
    }
}
