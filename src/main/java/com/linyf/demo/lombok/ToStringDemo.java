package com.linyf.demo.lombok;

import lombok.NonNull;
import lombok.ToString;

@ToString(of={"name", "age"})
public class ToStringDemo {
    private String name;

    private Integer age;

    private Integer gender;

    private String method(@NonNull  String name, Integer age){
        return null;
    }
}
