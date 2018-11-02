package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Tao
 */
@Configuration
public class DatabaseConfiguration {
    @Bean
    @ConditionalOnMissingBean(PlatformTransactionManager.class)
    public PlatformTransactionManager jpaTransactionManager(){
        return new JpaTransactionManager();
    }
}
