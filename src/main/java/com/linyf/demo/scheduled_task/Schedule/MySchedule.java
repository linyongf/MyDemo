package com.linyf.demo.scheduled_task.Schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

//@Component
public class MySchedule {
    /**
     * fixedRate 表示任务执行之间的时间间隔，具体是指两次任务的开始时间间隔，即第二次任务开始时，第一次任务可能还没结束。
     */
    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        System.out.println("fixedRate>>>"+ LocalTime.now());
    }

    /**
     * fixedDelay 表示任务执行之间的时间间隔，具体是指本次任务结束到下次任务开始之间的时间间隔
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelay() {
        System.out.println("fixedDelay>>>"+new Date());
    }

    /**
     * initialDelay表示首次任务启动的延迟时间
     * 所有时间的单位都是毫秒。
     */
    @Scheduled(initialDelay = 10000,fixedDelay = 5000)
    public void initialDelay() {
        System.out.println("initialDelay>>>"+new Date());
    }

    /**
     * cron表达式 可以配置在application.properties中
     */
    @Scheduled(cron = "${cronStr}")
    public void cron() {
        System.out.println("cron:" + new Date());
    }
}
