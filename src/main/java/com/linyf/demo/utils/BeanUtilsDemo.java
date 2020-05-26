package com.linyf.demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();

        BeanUtils.setProperty(user, "name", "zhangsan");
        String name = BeanUtils.getProperty(user, "name");
        System.out.println(name);
    }
}
