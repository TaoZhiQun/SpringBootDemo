package com.example.util;

import java.text.ParseException;

public class DateUtilTest {
    public static class TestSimpleDateForMatThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println(this.getName() + ":" + DateUtil.parseDateTime("2018-10-08 17:02:20"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20_000; i++) {
            new TestSimpleDateForMatThread().start();
        }
    }
}
