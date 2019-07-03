package com.example.javademo.block;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

class TaoWorkder extends Thread {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String workName;
    int workTime;
    CountDownLatch latch;

    public TaoWorkder(String workName, int workTime, CountDownLatch latch) {
        this.workName = workName;
        this.workTime = workTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("工人"+workName+"开始工作"+sdf.format(new Date()));
        doWork();
        System.out.println("工人"+workName+"停止工作"+sdf.format(new Date()));
        latch.countDown();
    }

    private void doWork(){
        try {
            Thread.sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        TaoWorkder worker1 = new TaoWorkder("zhang san",5000,countDownLatch);
        TaoWorkder worker2 = new TaoWorkder("li si",8000,countDownLatch);
        worker1.start();
        worker2.start();
        countDownLatch.await();
        System.out.println(sdf.format(new Date()));
    }
}
