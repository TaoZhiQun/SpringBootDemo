package com.example.test.other;

import io.netty.util.concurrent.FastThreadLocal;

public class CalculateTest {
    private static FastThreadLocal<Integer> threadLocal = new FastThreadLocal<>();

    public static void main(String[] args) {
        new Thread(CalculateTest::calculate, "thread1").start();
        new Thread(CalculateTest::calculate, "thread2").start();
        new Thread(CalculateTest::calculate, "thread3").start();
        new Thread(CalculateTest::calculate, "thread4").start();
        new Thread(CalculateTest::calculate, "thread5").start();
    }

    private static void calculate() {
        final long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000_0000; i++) {
                threadLocal.set(i);
            }
            final long end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadLocal.remove();
        }
    }
}
