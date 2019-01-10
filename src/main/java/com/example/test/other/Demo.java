package com.example.test.other;

import org.junit.jupiter.api.Test;

import java.beans.Transient;

public class Demo {

    public static void main(String[] args) {
        double d1 = 3.14;
        double d2  = d1;
        Double o1 = d1;
        Double o2 = d2;
        System.out.println(o1 == o2 ? "yes":"no");


    }


    private static long factorHelper(long acc,long n){
        return n == 1 ? acc:factorHelper(acc*n,n-1);
    }
}
