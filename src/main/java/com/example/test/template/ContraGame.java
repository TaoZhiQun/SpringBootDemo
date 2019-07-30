package com.example.test.template;

public class ContraGame extends Game {
    @Override
    protected void runGame() {
        System.out.println("启动魂斗罗2");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("1P正在使用S弹打");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("1P Game Over");
    }
}
