package com.example.test.proxy;

public class Secretary {
    private Boss boss;

    private String name;

    public Secretary(Boss boss, String name) {
        this.boss = boss;
        this.name = name;
    }

    void ok(){
        boss.ok();
    }

    void notOk(){
        boss.notOk();
    }
}
