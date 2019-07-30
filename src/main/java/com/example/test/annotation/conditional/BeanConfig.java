package com.example.test.annotation.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional({WindowsCondition.class})
public class BeanConfig {

    @Bean
    public Person person1(){
        return new Person("Windows",30);
    }

    @Bean
    public Person person2(){
        return new Person("Linux",30);
    }
}
