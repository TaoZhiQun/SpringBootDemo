package com.example.test.memento;

import java.io.Serializable;

public class SaveMsg implements Serializable {
    private int level;
    private int life;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public SaveMsg(int level, int life) {
        this.level = level;
        this.life = life;

    }
}
