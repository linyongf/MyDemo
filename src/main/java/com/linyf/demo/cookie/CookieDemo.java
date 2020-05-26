package com.linyf.demo.cookie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieDemo {
    @GetMapping("/testCookie")
    public String testCookie(HttpServletResponse res){
        Cookie cookie = new Cookie("name", "zhangsan");
        res.addCookie(cookie);
        return "testCookie";
    }
    @GetMapping("/")
    public String flushCookie(){
        return "flushCookie";
    }
}
