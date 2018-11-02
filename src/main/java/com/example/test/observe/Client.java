package com.example.test.observe;

public class Client {
    public static void main(String[] args) {
        HuKangKang huKangKang = new HuKangKang();
        huKangKang.addObserver(new Tao());
        huKangKang.doSomething("LOL");
    }

}
