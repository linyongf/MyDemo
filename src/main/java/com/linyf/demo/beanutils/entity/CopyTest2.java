package com.linyf.demo.beanutils.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class CopyTest2 {
    public String outerName;
    public InnerClass innerClass;
    public List clazz;

    @ToString
    @Data
    public static class InnerClass {
        public String InnerName;
    }
}
