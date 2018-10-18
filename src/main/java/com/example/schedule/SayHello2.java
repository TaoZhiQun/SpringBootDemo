package com.example.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// @Component
public class SayHello2 {
    @Scheduled(cron = "0/1 * * * * ?")
    void sayHello1(){
        Thread current = Thread.currentThread();
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"-------->>>每秒Hello1--------");
    }

    @Scheduled(fixedDelay=1000)
    @Async
    void sayHello2() throws InterruptedException {
        Thread current = Thread.currentThread();
        Thread.sleep(10000);
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"--------每秒Hello2,不受执行时间影响--------");
    }
}
