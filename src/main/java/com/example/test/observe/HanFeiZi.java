package com.example.test.observe;

import java.util.ArrayList;

public class HanFeiZi implements Observable,IHanFeiZi {

    private ArrayList<Observer> observerList = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了");

    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了");

    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String context) {

    }
}
