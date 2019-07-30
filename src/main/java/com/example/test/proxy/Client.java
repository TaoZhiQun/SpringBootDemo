package com.example.test.proxy;

public class Client {
    public static void main(String[] args) {
        SubjectProxy proxy = new SubjectProxy();
        final Subject subject = (Subject) proxy.bind(new RealSubject());
        subject.operate();
    }
}
