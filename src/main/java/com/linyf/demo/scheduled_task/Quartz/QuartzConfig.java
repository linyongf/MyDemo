package com.linyf.demo.scheduled_task.Quartz;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * 1.JobDetail 的配置有两种方式：MethodInvokingJobDetailFactoryBean 和 JobDetailFactoryBean 。
 * 2.使用 MethodInvokingJobDetailFactoryBean 可以配置目标 Bean 的名字和目标方法的名字，这种方式不支持传参。
 * 3.使用 JobDetailFactoryBean 可以配置 JobDetail ，任务类继承自 QuartzJobBean ，这种方式支持传参，将参数封装在 JobDataMap 中进行传递。
 * 4.Trigger 是指触发器，Quartz 中定义了多个触发器，这里向大家展示其中两种的用法，SimpleTrigger 和 CronTrigger 。
 * 5.SimpleTrigger 有点类似于前面说的 @Scheduled 的基本用法。
 * 6.CronTrigger 则有点类似于 @Scheduled 中 cron 表达式的用法。
 */
@Configuration
public class QuartzConfig {
    @Bean
    HelloService helloService() {
        return new HelloService();
    }

    /**
     * 配置目标 Bean 的名字和目标方法的名字，这种方式不支持传参
     *
     * @return
     */
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myJob1");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        bean.setStartTime(new Date());
        bean.setRepeatCount(5); //执行次数 n+1 好像没什么意义
        bean.setRepeatInterval(3000); //执行间隔
        return bean;
    }


    /**
     * 1.设置job
     * 2.设置jobDataMap
     * job(任务类)继承自 QuartzJobBean ，这种方式支持传参，将参数封装在 JobDataMap 中进行传递
     *
     * @return
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(MyJob2.class);

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("helloService", helloService());
        jobDataMap.put("lyf", "qx");
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
        return jobDetailFactoryBean;
    }

    /**
     * 1.设置cron表达式 ---什么时候执行
     * 2.设置jobDetail
     *
     * @return
     */
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("0/10 * * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }


    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(
//                simpleTriggerFactoryBean().getObject(),
                cronTriggerFactoryBean().getObject()
        );
        return schedulerFactoryBean;
    }
}
