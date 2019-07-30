package com.example.test.callback;

import org.apache.commons.lang3.RandomUtils;

public class Li {
    public void execute(Callback callback,String question){
        System.out.println("question: "+question);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = ""+RandomUtils.nextInt(10,20);
        callback.solve(result);
    }
}
