package com.example.test.state;

public class HeadSet {
    private MusicState state;
    private int i;

    public HeadSet(MusicState state) {
        this.state = state;
    }

    public void press() {
        if ((i & 1) == 0) {
            this.state = new PlayState();
        } else {
            this.state = new PauseState();
        }
        this.state.press();
        ++i;
    }


    public MusicState getState() {
        return state;
    }

    public void setState(MusicState state) {
        this.state = state;
    }
}
