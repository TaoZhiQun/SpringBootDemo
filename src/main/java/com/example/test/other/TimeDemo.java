package com.example.test.other;

import com.example.util.DateUtil;

public class TimeDemo {
    public static void main(String[] args) {
        String startLimitTime ="18:00:09";
        String endLimitTime ="01:05:09";
        String currentTime = DateUtil.currentTime();
        // 判断是否在此时间区间内 跨天
        if(currentTime.compareTo(endLimitTime)>0&&currentTime.compareTo(startLimitTime)<0){
            System.out.println("不在该时间区间内");
        }else{
            System.out.println("在该时间区间内");
        }
    }
}
