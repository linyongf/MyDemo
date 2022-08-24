package com.linyf.demo.condition_anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().getSystemProperties().put("people","北方人");
        ctx.register(FoodConfig.class);
//        ctx.getEnvironment().setActiveProfiles("南方人");
//        ctx.register(FoodProfile.class);
        ctx.refresh();

        Food food = (Food) ctx.getBean("food");
        food.showName();
    }

}
