package com.linyf.demo.cors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许访问本服务的ip地址
                .allowedOrigins("http://localhost:8083")
                .allowedHeaders("*").allowedMethods("*").maxAge(30);
    }
}
