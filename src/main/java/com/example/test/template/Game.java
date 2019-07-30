package com.example.test.template;

public abstract class Game {
    protected  abstract void runGame();
    protected void choosePerson(){};
    protected  abstract void startPlayGame();
    protected abstract void endPlayGame();
    public final void play(){
        runGame();
        choosePerson();
        startPlayGame();
        endPlayGame();
    }
}
