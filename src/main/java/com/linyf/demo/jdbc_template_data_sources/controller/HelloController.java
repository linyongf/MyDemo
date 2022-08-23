package com.linyf.demo.jdbc_template_data_sources.controller;

import com.linyf.demo.jdbc_template_data_sources.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HelloController {
    /**
     * ---说明：按类型注入 JdbcTemplate变量名字需要和@Bean注解方法名一样 ，否则编译不通过，注入不成功
     * 也可以通过@Resource byName方式注入
     */
    @Autowired
    JdbcTemplate jt1;
    @Autowired
    JdbcTemplate jt2;

    @GetMapping("/user")
    public List<User> getAllUser() {
        List<User> list = jt1.query("select * from tb_jdbctemplate", new BeanPropertyRowMapper<>(User.class));
        return list;
    }
    @GetMapping("/user2")
    public List<User> getAllUser2() {
        List<User> list = jt2.query("select * from tb_jdbctemplate", new BeanPropertyRowMapper<>(User.class));
        return list;
    }
}
