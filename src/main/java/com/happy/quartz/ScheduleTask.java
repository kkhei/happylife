package com.happy.quartz;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;  
/**
 * 
 * @author zhaohappy
 * @time 2019年12月12日
 * @description 定时器
 */
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加  
public class ScheduleTask {  
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);  
    
    @Value("${my.test.name}")
    private String test;
    
    @Async
    @Scheduled(cron="${my.test.cron}")
    public void printVal(){
    	
    	LOGGER.info(test+Thread.currentThread().getName());
    }

    @Async
    @Scheduled(cron="${my.test.cron}")
    public void printVal2(){
        System.out.println("2"+test+Thread.currentThread().getName());
    }
} 