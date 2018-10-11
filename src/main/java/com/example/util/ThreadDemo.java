package com.example.util;

public class ThreadDemo  implements Runnable{
    int b = 100;
    synchronized void m1() throws InterruptedException{
        System.out.println("Hello");
        b =1000;
        Thread.sleep(500);
        System.out.println("b="+b);
    }
    synchronized void m2() throws InterruptedException{
        System.out.println("----");
        Thread.sleep(250);
        b=2000;
    }

    public static void main(String[] args) throws InterruptedException {
            ThreadDemo tt = new ThreadDemo();
            Thread thread = new Thread(tt);
            thread.start();
            tt.m2();
            System.out.println("main thread b="+tt.b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
