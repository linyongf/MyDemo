package com.linyf.demo.utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GoogleGuavaDemo1 {
    public static void main(String[] args) {
        // 一个键映射一个集合
        // use java
        // Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        // use guava
        Multimap<Object, Object> map = ArrayListMultimap.create();
        map.put("key1", 1);
        map.put("key1", 2);
        map.put("key2", 2);
        map.put("key2", 2);
        // [1, 2]
        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
    }
}
