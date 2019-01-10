package com.example.test.strategy;

public class Validator {
    private  ValidationStrategy validationStrategy;
    public Validator(ValidationStrategy v){
        this.validationStrategy=v;
    }
    boolean validate(String s){
        return validationStrategy.execute(s);
    }

}
