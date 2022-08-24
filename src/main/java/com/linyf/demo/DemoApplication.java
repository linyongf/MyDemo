package com.linyf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  要实现定时任务，我们有两中方案，一种是使用 Spring 自带的定时任务处理器 @Scheduled 注解，另一种就是使用第三方框架 Quartz
 *  Quartz 在使用过程中，有两个关键概念，一个是JobDetail（要做的事情），另一个是触发器（什么时候做），要定义 JobDetail，
 *  需要先定义 Job和JobDataMap，Job 的定义有两种方式
 */
@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
