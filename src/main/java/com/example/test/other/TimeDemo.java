package com.example.test.other;

import com.example.util.DateUtil;

public class TimeDemo {
    public static void main(String[] args) {
        // 1可以出金 2限制出金
        String startLimitTime = "1:28:30";
        String endLimitTime = "15:28:30";
        String currentTime = "1:28:30";
        // 如果在限制范围时间内返回2(不许出金)
        if(startLimitTime.compareTo(endLimitTime)<0){
            if(currentTime.compareTo(startLimitTime)>0&&currentTime.compareTo(endLimitTime)<0){
                System.out.println("可以出金");
            }else {
                System.out.println("限制出金");
            }
        }else if(startLimitTime.compareTo(endLimitTime)>0){
            // 开始时间大于结束时间
            if(currentTime.compareTo(endLimitTime)>0&&currentTime.compareTo(startLimitTime)<0){
                System.out.println("限制出金");
            }else{
                System.out.println("可以出金");
            }
        }else {
            //如果开始时间等于结束时间
            if(currentTime.compareTo(startLimitTime) ==0){
                System.out.println("可以出金");
            }else {
                System.out.println("限制出金");
            }
        }
    }
}
