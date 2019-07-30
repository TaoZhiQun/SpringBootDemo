package com.example.test.callback;

public class Wang implements Callback{
    private Li li;

    public Wang(Li li){
        this.li = li;
    }

    public void askQuestion(String question){
        new Thread(() -> li.execute(Wang.this,question)).start();
        doSelf();
    }
    @Override
    public void solve(String result) {
        System.out.println("获知答案为"+result);
    }

    public void doSelf(){
        System.out.println("做自己的事情");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
