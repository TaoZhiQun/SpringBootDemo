package com.example.test.observe;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObserver(String sweet);
}
