package com.example.listener;

import com.example.entity.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInfoListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        final ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        final UserService userService = applicationContext.getBean(UserService.class);
        final List<User> allUser = userService.findAllUser();
        System.out.println(allUser);
    }
}
