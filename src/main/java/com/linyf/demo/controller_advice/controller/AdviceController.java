package com.linyf.demo.controller_advice.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AdviceController {
    //InitBinder
    @RequestMapping(value = "/users1", method = RequestMethod.GET)
    public void users(Date date) {
        System.out.println(date); // Tue May 02 00:00:00 CST 2019
    }

    //ModelAttribute
    @GetMapping("/index1")
    public String index(ModelMap modelMap) {
        System.out.println(modelMap.get("words"));
        return modelMap.get("words").toString();
    }

    ////ModelAttribute
    // 也可以通过@ModelAttribute获取
    @RequestMapping("/index2")
    public String index(@ModelAttribute("words") String words) {
        System.out.println(words);
        return words;
    }

    //ModelAttribute

    /**
     * 从输出结果上看，使用@ModelAttribute注解标注的方法确实在目标方法执行之前执行了。
     * 需要说明的是，@ModelAttribute标注的方法的执行是在所有的拦截器的preHandle()方法执行之后才会执行。
     * @param message
     */
    @RequestMapping(value = "/users3", method = RequestMethod.GET)
    public void users(@ModelAttribute("message") String message) {
        System.out.println(message);
    }

    /**
     * ExceptionHandler
     * 当访问/users的时候，因为在该方法中抛出了RuntimeException，那么异常捕获器就会捕获该异常，然后返回我们定义的异常视图（默认的error视图）
     */
    @GetMapping(value = "/users")
    public void users() {
        throw new RuntimeException("没有任何用户。");
    }
}
