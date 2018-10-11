package com.example.test.observe;

public class LiSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("观察到韩非子活动，开始汇报");
        reportToQin(context);
        System.out.println("汇报完毕");
    }
    private void reportToQin(String report){
        System.out.println("韩非子开始活动了"+report);
    }
}
