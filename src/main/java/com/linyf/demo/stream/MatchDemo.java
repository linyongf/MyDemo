package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;

public class MatchDemo {
    public static void main(String[] args) {
        Person p1 = Person.builder().name("黄药师").age(57).uniqueSkill("碧海潮生曲").build();
        Person p2 = Person.builder().name("欧阳锋").age(55).uniqueSkill("蛤蟆功").build();
        Person p3 = Person.builder().name("洪七公").age(57).uniqueSkill("降龙十八掌").build();
        Person p4 = Person.builder().name("周伯通").age(52).uniqueSkill("双手互博").build();
        Person p5 = Person.builder().name("郭靖").age(30).uniqueSkill("降龙十八掌").build();

        List<Person> list = new ArrayList<Person>() {{
            add(p1);
            add(p2);
            add(p3);
            add(p4);
            add(p5);
        }};

        boolean allMatch = list.stream().allMatch(i -> i.getAge() >= 18);
        if(allMatch){
            System.out.println("全部大于18岁");
        }

        boolean anyMatch = list.stream().anyMatch(i -> i.getAge() == 30);
        if(anyMatch){
            System.out.println("有30岁的人");
        }

        boolean noneMatch = list.stream().noneMatch(i -> i.getAge() < 18);
        if(noneMatch){
            System.out.println("没有小于18岁的人");
        }
    }
}
