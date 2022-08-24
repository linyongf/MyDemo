package com.linyf.demo.system_start_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1、首先通过 @Compoent 注解将 MyCommandLineRunner1 注册为Spring容器中的一个 Bean。
 * 2、添加 @Order注解，表示这个启动任务的执行优先级，因为在一个项目中，启动任务可能有多个，所以需要有一个排序。@Order 注解中，数字越小，优先级越大，默认情况下，优先级的值为 Integer.MAX_VALUE，表示优先级最低。
 * 3、在 run 方法中，写启动任务的核心逻辑，当项目启动时，run方法会被自动执行。
 * 4、run 方法的参数，来自于项目的启动参数，即项目入口类中，main方法的参数会被传到这里。
 *
 * 至于参数，可以通过两种方式来传递，
 * 1.如果是在 IDEA 中，可以通过如下方式来配置参数： Run/Debug Configurations->Configuration->Environment->Program Arguments
 * 2.另一种方式，则是将项目打包，在命令行中启动项目，然后启动时在命令行传入参数，如下：java -jar devtools-0.0.1-SNAPSHOT.jar 三国演义 西游记
 */
@Component
@Order(100)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.asList(args));
    }
}
