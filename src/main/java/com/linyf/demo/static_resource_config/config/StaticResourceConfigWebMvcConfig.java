package com.linyf.demo.static_resource_config.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 在 Spring Boot 中，默认情况下，一共有 5 个位置可以放静态资源，五个路径分别是如下 5 个：
 * classpath:/META-INF/resources/   采用配置文件配置spring.resources.static-locations和spring.mvc.static-path-pattern的时候，这个一直生效，
 *                                  采用配置类时，addResourceHandlers(ResourceHandlerRegistry registry){
 *                                  registry.addResourceHandler("/**").addResourceLocations("classpath:/img/");这个不生效
 * classpath:/resources/
 * classpath:/static/
 * classpath:/public/
 * /
 * 分别对应了 resources 目录下不同的目录，在 Spring Boot 项目中，默认是没有 webapp 这个目录的，这里第 5 个 / 其实就是表示 webapp 目录中的静态资源也不被拦截。
 * 如果同一个文件分别出现在五个目录下，那么优先级也是按照上面列出的顺序。
 */
@Configuration
public class StaticResourceConfigWebMvcConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/img/");
//    }
}
