package com.example.test.proxy;

public class TestCglib {
    public static void main(String[] args) {
        SubjectCglib cglib = new SubjectCglib();
        final SubjectImpl subject = (SubjectImpl)cglib.getInstance(new SubjectImpl());
        subject.operate();
    }
}
