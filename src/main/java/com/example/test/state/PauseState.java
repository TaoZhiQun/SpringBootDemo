package com.example.test.state;

public class PauseState implements MusicState {
    @Override
    public void press() {
        System.out.println("暂停音乐");
    }
}
