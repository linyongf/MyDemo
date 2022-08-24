package com.linyf.demo.condition_anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FoodProfile {
    @Bean("food")
    @Profile("南方人")
    Food rice(){
        return new Rice();
    }

    @Bean("food")
    @Profile("北方人")
    Food noodles(){
        return new Noodles();
    }
}
