package com.example.test.other;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] arg, Object target) throws Throwable {
        System.out.println("Point"+ target.getClass().getName() +method.getName());
        String clientName = (String) arg[0];
        System.out.println(clientName);
    }
}
