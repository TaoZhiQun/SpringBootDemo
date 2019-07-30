package com.example.test.callback;

public class Client {
    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("wang ask a question");
    }
}
