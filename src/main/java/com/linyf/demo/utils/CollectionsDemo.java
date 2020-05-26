package com.linyf.demo.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("3", "4", "5", "6");
        List<String> list3 = Arrays.asList("1", "2", "3");

        // 判空 null size=0 都是true
        System.out.println("==========判空===========");
        boolean empty = CollectionUtils.isEmpty(new ArrayList());
        System.out.println("是否为空：" + empty);

        // 并集 是 去重的
        System.out.println("=============并集==============");
        List<String> union = (List<String>) CollectionUtils.union(list1, list2);
        for (String o : union) {
            System.out.println(o);
        }

        //交集
        System.out.println("==============交集===============");
        List<String> retain = (List<String>) CollectionUtils.retainAll(list1, list2);
        for (String s : retain) {
            System.out.println(s);
        }

        //差集
        System.out.println("==============差集===============");
        List<String> subtract = (List<String>) CollectionUtils.subtract(list1, list2);
        for (String s : subtract) {
            System.out.println(s);
        }

        //判等 比较的是两个集合中的元素
        System.out.println("==============判等===============");
        Boolean isEqual = CollectionUtils.isEqualCollection(list1, list3);
        System.out.println("list1 == list2: " + isEqual);
    }
}
