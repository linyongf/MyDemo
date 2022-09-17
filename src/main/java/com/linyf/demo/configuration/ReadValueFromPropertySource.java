package com.linyf.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:beanName.properties")
@Configuration
public class ReadValueFromPropertySource {
    @Value("${bean.name.component}")
    String beanName;

    @Bean("myTestBean")
    public MyBean myBean(){
        return new MyBean(beanName);
    }
}
