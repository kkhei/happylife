package com.happy;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * 
 * @author zhaohaibin
 * @date 2019-12-02	
 * @describe springboot启动类   @EnableAsync异步执行
 */
@EnableAsync
@MapperScan("com.happy.dao")
@SpringBootApplication // Spring Boot项目的核心注解，主要目的是开启自动配置
public class HelloApplication {
    // 在main方法中启动一个应用，即：这个应用的入口
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
