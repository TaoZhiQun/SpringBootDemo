package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步线程池的配置
 * @author Tao
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig {
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(400);
        // 设置最大线程数
        executor.setMaxPoolSize(1000);
        // 设置队列容量
        executor.setQueueCapacity(1000);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("个人线程-");
        // 设置拒绝策略 对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy ());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
