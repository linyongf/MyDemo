package com.linyf.demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsDemo1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        //实体类转Map 不过泛型只能是<String, String>
        Map<String, String> desMap = BeanUtils.describe(user);
        System.out.println(desMap);

        user = new User();
        Map<String, Object> popMap = new HashMap<>();
        popMap.put("name", "lisi");
        popMap.put("age", "20");
        //这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
        // Map转实体类 Map泛型可以是<String, Object>
        BeanUtils.populate(user, popMap);
        System.out.println(user);
    }
}
