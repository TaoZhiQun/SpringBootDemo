package com.example.test.observe;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    private final List<Observer> observerList = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void notifyObserver(String sweet) {
        observerList.forEach(o->o.notify(sweet));
    }
}
