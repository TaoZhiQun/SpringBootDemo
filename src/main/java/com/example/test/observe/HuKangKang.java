package com.example.test.observe;

import java.util.Observable;

public class HuKangKang extends Observable {
    private String context;
    public String getContext() {
        return context;
    }

    public void doSomething(String context) {
        this.context =context;
        setChanged();
        notifyObservers();
    }

}
