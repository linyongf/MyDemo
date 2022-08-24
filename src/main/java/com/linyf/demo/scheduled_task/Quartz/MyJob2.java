package com.linyf.demo.scheduled_task.Quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * 这种方式支持传参，任务启动时，executeInternal 方法将会被执行
 * MyJob2 中的属性只能通过 JobDataMap.put 进行设置
 */
public class MyJob2 extends QuartzJobBean {
    private HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.sayHello();
        Object lyf = jobExecutionContext.getJobDetail().getJobDataMap().get("lyf");
        System.out.println(lyf.toString());
    }
}

class HelloService{
    public void sayHello(){
        System.out.println("HelloService>>>"+ LocalTime.now());
    }
}
