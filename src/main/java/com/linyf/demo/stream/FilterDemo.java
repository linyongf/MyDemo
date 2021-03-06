package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {
        Person p1 = Person.builder().name("黄药师").age(57).uniqueSkill("碧海潮生曲").build();
        Person p2 = Person.builder().name("欧阳锋").age(55).uniqueSkill("蛤蟆功").build();
        Person p3 = Person.builder().name("洪七公").age(57).uniqueSkill("降龙十八掌").build();
        Person p4 = Person.builder().name("周伯通").age(52).uniqueSkill("双手互博").build();

        List<Person> list = new ArrayList<Person>() {{
            add(p1);
            add(p2);
            add(p3);
            add(p4);
        }};

        List<Person> collect = testFilter(list);
        collect.forEach(System.out::println);
    }

    /**
     * 测试 filter 过滤
     * @param list
     * @return
     */
    private static List<Person> testFilter(List<Person> list) {
        return list.stream().filter(i -> i.getAge() == 57).collect(Collectors.toList());
    }
}
