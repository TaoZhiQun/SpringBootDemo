package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    @Singleton
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
