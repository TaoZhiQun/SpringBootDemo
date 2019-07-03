package com.example.test.memento;

public class Client {
    public static void main(String[] args) {
        int level =1;
        int life =100;
        Player player = new Player(level,life);
        player.getStatus();
        player.leveling();
        GameSavePage savePage = new GameSavePage();
        savePage.setSaveMsg(player.saveSateToMemento());
        final boolean challengeBoss = player.challengeBoss();
        System.out.println(challengeBoss);
        savePage.getSaveMsg();
        player.leveling();
        player.leveling();
        player.getStatus();
    }
}
