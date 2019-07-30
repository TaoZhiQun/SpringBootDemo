package com.example.test.template;

public class Client {
    public static void main(String[] args) {
        Game contraGame = new ContraGame();
        contraGame.play();
        System.out.println();
        Game tmntGame = new TMNTGame();
        tmntGame.play();
    }
}
