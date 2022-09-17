package com.linyf.demo.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationApplication {
    public static void main(String[] args) {

        // 为了展示配置文件的完整性，之前的代码没有删除。
//        AnnotationConfigApplicationContext context = = new AnnotationConfigApplicationContext(MyConfiguration.class)
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(MyConfiguration.class);
//        context.refresh();
//
//        // 获取启动过程中的bean 定义的名称
//        for(String str : context.getBeanDefinitionNames()){
//            System.out.println("str = " + str);
//        }
//        context.close();

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ReadValueFromPropertySource.class);
        MyBean myBean = (MyBean) context.getBean("myTestBean");
        System.out.println("myBean = " + myBean);

    }
}
