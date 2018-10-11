package com.example.test.observe;

/**
 * 被观察者
 * @author Tao
 */
public interface Observable {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver(String context);
}
