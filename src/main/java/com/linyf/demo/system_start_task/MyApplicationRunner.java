package com.linyf.demo.system_start_task;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * ApplicationRunner 可以接收更多类型的参数（ApplicationRunner 除了可以接收 CommandLineRunner 的参数之外，还可以接收 key/value 形式的参数）
 *
 * ApplicationRunner 定义完成后，传启动参数也是两种方式，参数类型也有两种，第一种和 CommandLineRunner 一致，第二种则是 --key=value 的形式
 */
@Component
@Order(99)
public class MyApplicationRunner implements ApplicationRunner {

    /**
     * 1.args.getNonOptionArgs();可以用来获取命令行中的无key参数（和CommandLineRunner一样）。
     * 2.args.getOptionNames();可以用来获取所有key/value形式的参数的key。
     * 3.args.getOptionValues(key));可以根据key获取key/value 形式的参数的value。
     * 4.args.getSourceArgs(); 则表示获取命令行中的所有参数
     *
     * Run/Debug Configurations->Configuration->Environment->Program Arguments >>> linyf qx --linyf=qx --foo=bar --foo=baz
     * MyApplicationRunner1:nonOptionArgs>>>[linyf, qx]
     * MyApplicationRunner1:>>>foo:[bar, baz]
     * MyApplicationRunner1:>>>linyf:[qx]
     * MyApplicationRunner1:sourceArgs>>>[linyf, qx, --linyf=qx, --foo=bar, --foo=baz]
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("MyApplicationRunner1:nonOptionArgs>>>"+nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String key : optionNames) {
            System.out.println("MyApplicationRunner1:>>>"+key + ":" + args.getOptionValues(key));
        }
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("MyApplicationRunner1:sourceArgs>>>"+ Arrays.toString(sourceArgs));
    }
}
