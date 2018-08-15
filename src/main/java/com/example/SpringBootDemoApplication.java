package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *  应用启动入口函数，直接以debug或者run方式运行即可
 */
@ComponentScan(basePackages = {"com.example"})
@SpringBootApplication
@MapperScan("com.example.mapper")
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
