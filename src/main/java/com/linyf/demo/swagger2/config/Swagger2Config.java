package com.linyf.demo.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")   //映射路径
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.linyf.demo.swagger2.controller"))//     要扫描的接口
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()       //Swagger2 文档网站的信息
                                .title("SpringBoot 整合Swagger")
                                .description("SpringBoot整合Swagger,详细信息。。。")
                                .version("9.0")
                                .contact(new Contact("LinYongFei","https://swagger.io/","fei624195882@163.com"))
                                .license("The Apache License")
                                .licenseUrl("https://www.baidu.com")
                                .build());
    }

//    如果我们的Spring Boot项目中集成了Spring Security，那么如果不做额外配置，Swagger2文档可能会被拦截，此时只需要在Spring Security的配置类中重写configure方法，添加如下过滤即可：
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring()
//                .antMatchers("/swagger-ui.html")
//                .antMatchers("/v2/**")
//                .antMatchers("/swagger-resources/**");
//    }
}
