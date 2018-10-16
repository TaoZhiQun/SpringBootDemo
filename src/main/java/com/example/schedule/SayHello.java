package com.example.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class SayHello {
    @Scheduled(cron = "0/1 * * * * ?")
    void sayHello1() throws InterruptedException {
        Thread current = Thread.currentThread();
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"-------->>>每秒Hello1--------");
        Thread.sleep(10000);
    }
    @Scheduled(cron = "0/1 * * * * ?")
    void sayHello2(){
        Thread current = Thread.currentThread();
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"--------每秒Hello2--------");
    }

    @Scheduled(cron = "0/1 * * * * ?")
    void sayHello3() throws InterruptedException {
        Thread current = Thread.currentThread();
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"--------===每秒Hello3--------");
        Thread.sleep(10000);
    }

    @Scheduled(cron = "0/1 * * * * ?")
    void sayHello4(){
        Thread current = Thread.currentThread();
        System.out.println("id:"+current.getId()+"name:"+current.getName()+"--------每秒Hello4--------");
    }

}
