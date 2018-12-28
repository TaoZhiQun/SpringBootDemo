package com.example.test.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormateDemo extends Thread {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String dateStr;
    public SimpleDateFormateDemo(String name,String dateStr){
        this.name = name;
        this.dateStr = dateStr;
    }
    @Override
    public void run() {
        try {
          //System.out.println("字符串"+dateStr);
            Date date = sdf.parse(dateStr);
            System.out.println(name + ":日期:"+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        executorService.execute(new SimpleDateFormateDemo("A","2018-12-27"));
        executorService.execute(new SimpleDateFormateDemo("B","2018-12-26"));
      //  executorService.shutdown();
    }
}
