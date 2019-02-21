package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  应用启动入口函数，直接以debug或者run方式运行即可
 * @author Tao
 */
@ComponentScan(basePackages = {"com.example"})
@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.mapper")
@ServletComponentScan
@EnableAsync
public class SpringBootDemoApplication extends SpringBootServletInitializer {
    /**
     *  配置到tomcat上需要使用
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootDemoApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
