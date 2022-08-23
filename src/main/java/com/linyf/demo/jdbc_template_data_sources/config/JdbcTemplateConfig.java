package com.linyf.demo.jdbc_template_data_sources.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * 每一个 JdbcTemplate 的创建都需要一个 DataSource，由于 Spring 容器中现在存在两个 DataSource，
 * 默认使用类型查找，会报错，因此加上 @Qualifier 注解，表示按照名称查找。这里创建了两个 JdbcTemplate 实例，分别对应了两个 DataSource。
 *
 * ---说明：按类型注入 DataSource变量名字需要和@Bean注解方法名一样 ，否则编译不通过，
 *          也可以通过@Resource byName方式注入
 */
@Configuration
public class JdbcTemplateConfig {
    @Bean
    JdbcTemplate jt1(DataSource ds1){
        return new JdbcTemplate(ds1);
    }

    @Bean
    JdbcTemplate jt2(DataSource ds2){
        return new JdbcTemplate(ds2);
    }
}
