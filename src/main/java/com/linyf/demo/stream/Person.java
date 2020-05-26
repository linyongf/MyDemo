package com.linyf.demo.stream;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class Person {
    private Long id;

    private String name;

    private int age;

    /**
     * 绝技
     */
    private String uniqueSkill;
}
