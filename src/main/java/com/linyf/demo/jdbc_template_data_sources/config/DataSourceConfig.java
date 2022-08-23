package com.linyf.demo.jdbc_template_data_sources.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 这里提供了两个 Bean，其中 @ConfigurationProperties 是 Spring Boot 提供的类型安全的属性绑定，
 * 以第一个Bean为例， @ConfigurationProperties(prefix = "spring.datasource.one") 表示使用 spring.datasource.one 前缀的数据库配置去创建一个 DataSource，
 * 这样配置之后，我们就有了两个不同的 DataSource，接下来再用这两个不同的 DataSource 去创建两个不同的 JdbcTemplate。
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource ds1(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource ds2(){
        return DruidDataSourceBuilder.create().build();
    }
}
