package com.example.test.proxy;

public class client {
    public static void main(String[] args) {
        Boss tao = new Boss("Tao");
        Secretary chen = new Secretary(tao, "chen");
        chen.ok();
        chen.notOk();
    }
}
