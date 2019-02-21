package com.example.test.other;

import com.example.entity.Log;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

public class Demo {

    public static void main(String[] args) {
        double d1 = 3.14;
        double d2  = d1;
        Double o1 = d1;
        Double o2 = d2;
        System.out.println(o1 == o2 ? "yes":"no");

        Log log = new Log();
        log.setUserId(123L);
        log.setLoginIp("192.168.103.61");
        log.setOperateType(1);
        System.out.println(new Gson().toJson(log));


    }


    private static long factorHelper(long acc,long n){
        return n == 1 ? acc:factorHelper(acc*n,n-1);
    }
}
