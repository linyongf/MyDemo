package com.linyf.demo.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter()
@Getter
public class Person {
    private String name;

    private Integer age;
}

class Animal{

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String type;
}
