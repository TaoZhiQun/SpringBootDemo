package com.example.test.other;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static Map<Integer,Integer> map = new HashMap<Integer,Integer>(2);
    static AtomicInteger at = new AtomicInteger(1);
    @Override
    public void run() {
       while(at.get()<1000000){
           map.put(at.get(),at.get());
           at.incrementAndGet();
           System.out.println(at);
       }
    }
}
