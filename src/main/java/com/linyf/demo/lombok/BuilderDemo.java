package com.linyf.demo.lombok;

import lombok.*;
import lombok.extern.java.Log;

@ToString
@Builder
@Log
public class BuilderDemo {
    @NonNull private String name;
    private Integer age;
    private Integer sex;

    public static void main(String[] args) {
        BuilderDemo builderDemo = BuilderDemo.builder().name("张三").age(18).build();
        System.out.println(builderDemo.age);
        log.info(builderDemo.toString());
    }
}
