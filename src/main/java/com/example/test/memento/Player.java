package com.example.test.memento;

public class Player {
    private int level;
    private int life;

    public Player(int level, int life) {
        this.level = level;
        this.life = life;
    }

    public SaveMsg saveSateToMemento(){
        return new SaveMsg(level,life);
    }

    public void getStateFromMemento(SaveMsg sm){
        this.level = sm.getLevel();
        this.life = sm.getLife();
    }

    public void getStatus(){
        System.out.println("当前任务等级"+level+"人物生命"+life);
    }

    public void leveling(){
        this.life = this.life +10;
        this.level = this.level+1;
    }

    public boolean challengeBoss(){
        return this.level >2 && this.life >200;
    }


}
