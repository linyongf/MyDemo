package com.linyf.demo.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    /**
     * Core Pool Size :核心线程数线程数定义了最小可以同时运行的线程数量。
     * Queue Capacity :当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。
     * Maximum Pool Size :当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
     */
    private static final int CORE_POOL_SIZE = 2;//核心线程数
    private static final int MAX_POOL_SIZE = 10;//最大线程数
    private static final int QUEUE_CAPACITY = 100;//队列容量

    @Override
    public Executor getAsyncExecutor(){
        //默认 核心线程数是1 ，最大线程数Integer.MAX_VALUE，队列容量Integer.MAX_VALUE
        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();

        tpte.setCorePoolSize(CORE_POOL_SIZE);
        tpte.setMaxPoolSize(MAX_POOL_SIZE);
        tpte.setQueueCapacity(QUEUE_CAPACITY);
        tpte.setThreadNamePrefix("lyf-async-");
        /**
         * ThreadPoolTaskExecutor饱和策略定义:
         * 如果当前同时运行的线程数量达到最大线程数量时，ThreadPoolTaskExecutor定义一些策略:
         * ThreadPoolExecutor.AbortPolicy：默认。抛出RejectedExecutionException来拒绝新任务的处理。
         * ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，
         *                                      影响程序的整体性能。另外，这个策略喜欢增加队列容量。
         *                                      如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。
         * ThreadPoolExecutor.DiscardPolicy：不处理新任务，直接丢弃掉。
         * ThreadPoolExecutor.DiscardOldestPolicy：此策略将丢弃最早的未处理的任务请求。
         */
        //当队列线程满并且最大线程数也满时 需要采用适当饱和策略处理新请求（默认饱和策略不能满足）
        tpte.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        tpte.initialize();
        return tpte;
    }
}
