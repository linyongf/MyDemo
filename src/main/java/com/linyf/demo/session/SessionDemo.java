package com.linyf.demo.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionDemo {
    @GetMapping("/produceSession")
    public String testSession(HttpSession session){
        session.setAttribute("name","zhangsan");
        return "testSession";
    }
    @GetMapping("/getSession")
    public Object testGetSession(HttpSession session){
        return session.getAttribute("name");
    }
}
