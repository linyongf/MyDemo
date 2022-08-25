package com.linyf.demo.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    private List<String> movies = new ArrayList<String>(){{
        add("Forrest Gump");
        add("Titanic");
        add("Spirited Away");
        add("The Shawshank Redemption");
        add("Zootopia");
        add("Farewell");
        add("Joker");
        add("Crawl");
    }};

    /**
     * 此方法 有返回值 ，适用于所有任务执行完成后返回给前端结果
     * @param start
     * @return
     */
    @Async
    public CompletableFuture<List<String>> completableFutureTask(String start){
        //打印日志
        log.warn(Thread.currentThread().getName() + "start this task!");

        //找到特定start开始的电影
        List<String> collect = movies.stream().filter(movie -> movie.startsWith(start)).collect(Collectors.toList());

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(collect);
    }

    /**
     * 此方法 无返回值 ，适合不要求返回结果，慢慢去执行任务
     * @param start
     * @return
     */
    @Async
    public void completableFutureTask1(String start){
        //打印日志
        log.warn(Thread.currentThread().getName() + "start this task!");

        //找到特定start开始的电影
        movies.stream().filter(movie -> movie.startsWith(start)).collect(Collectors.toList());

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
