package com.linyf.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo1 {
    public static void main(String[] args) {
        Person p1 = Person.builder().id(1L).name("黄药师").age(57).uniqueSkill("碧海潮生曲").build();
        Person p2 = Person.builder().id(2L).name("欧阳锋").age(55).uniqueSkill("蛤蟆功").build();
        Person p3 = Person.builder().id(3L).name("洪七公").age(57).uniqueSkill("降龙十八掌").build();
        Person p4 = Person.builder().id(4L).name("周伯通").age(52).uniqueSkill("双手互博").build();

        List<Person> list = new ArrayList<Person>() {{
            add(p1);
            add(p2);
            add(p3);
            add(p4);
        }};

        List<Person> collect = list.stream()
                .sorted((i, j) -> Long.compare(i.getId(),j.getId()))
                .sorted((i, j) -> Integer.compare(i.getAge(), j.getAge()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
