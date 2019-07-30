package com.example.test.state;

public class PlayState implements MusicState {
    @Override
    public void press() {
        System.out.println("播放音乐");
    }
}
