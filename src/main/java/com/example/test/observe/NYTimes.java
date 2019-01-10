package com.example.test.observe;

public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if(null != tweet && tweet.contains("money")){
            System.out.println("NY:"+tweet);
        }
    }
}
