package com.happy.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * 
 * @author zhaohappy
 * @time 2019年12月12日
 * @description 异步执行 线程池
 */
@Configuration  
public class AsyncTaskPoolConfig {  
		@Bean(name = "taskExecutor")
	    public Executor taskExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(10);
	        executor.setMaxPoolSize(200);
	        executor.setQueueCapacity(50);
	        executor.setKeepAliveSeconds(60);
	        executor.setThreadNamePrefix("taskExecutor-happy-");
	        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	        return executor;
	    }
	
      
}  