package com.linyf.demo.async.controller;

import com.linyf.demo.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/movies")
    public String completableFutureTask(){
        //开始时间
        long startTime = System.currentTimeMillis();

        //开始执行异步任务
        List<String> list = Arrays.asList("F", "T", "S", "Z", "J", "C");
        List<CompletableFuture<List<String>>> completableFutures = list.stream().map(word -> asyncService.completableFutureTask(word)).collect(Collectors.toList());
        //CompletableFuture.join（）方法可以获取他们的结果并将结果连接起来
        List<List<String>> collect = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        //花费的时间
        System.out.println(System.currentTimeMillis()-startTime);
        return collect.toString();
    }

    @GetMapping("/movies1")
    public String completableFutureTask1(){
        //开始时间
        long startTime = System.currentTimeMillis();

        //开始执行异步任务
        List<String> list = Arrays.asList("F", "T", "S", "Z", "J", "C");
        list.stream().forEach(word -> asyncService.completableFutureTask1(word));

        //花费的时间
        System.out.println("用时：" + (System.currentTimeMillis()-startTime));

        return "Done";
    }
}
