package com.example.test.template;

public class TMNTGame extends Game {
    @Override
    protected void runGame() {
        System.out.println("启动忍者神龟2");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("启动忍者神龟2");
    }

    @Override
    protected void choosePerson() {
        System.out.println("1P选择RR");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("忍者神龟游戏结束");
    }
}
