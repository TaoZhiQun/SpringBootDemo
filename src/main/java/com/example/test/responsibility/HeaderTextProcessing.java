package com.example.test.responsibility;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul Mario And Alan:"+input;
    }
}
