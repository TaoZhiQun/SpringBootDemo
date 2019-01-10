package com.example.test.observe;

public class Client {
    public static void main(String[] args) {
       Feed  feed = new Feed();
       feed.registerObserver(new NYTimes());
       feed.notifyObserver("money");
    }

}
