package com.linyf.demo.jdbc_template.controller;

import com.linyf.demo.jdbc_template.entity.User;
import com.linyf.demo.jdbc_template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String addUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setAddress("CQ");
        userService.addUser1(user);
        return "Add 0k";
    }

    @GetMapping("/addUser1")
    public String addUser1(){
        User user = new User();
        user.setId(2);
        user.setUsername("lisi");
        user.setAddress("LH");
        userService.addUser2(user);
        return "Add 0k";
    }

    @GetMapping("/delUser")
    public String delUser(){
        userService.deleteUserById(1L);
        return "DEL 0k";
    }

    @GetMapping("/udpUser")
    public String udpUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("lisi");
        user.setAddress("CQ");
        userService.updateUserById(user);
        return "udp 0k";
    }

    @GetMapping("/findUser")
    public List<User> findUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/findUser1")
    public List<User> findUser1(){
        return userService.getAllUsers2();
    }
}
