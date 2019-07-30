package com.example.test.state;

public class Client {
    public static void main(String[] args) {
        HeadSet hs = new HeadSet(new PlayState());
        hs.press();
        hs.press();
        hs.press();
    }
}
