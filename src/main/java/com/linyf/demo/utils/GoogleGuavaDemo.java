package com.linyf.demo.utils;

import com.google.common.collect.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoogleGuavaDemo {
    public static void main(String[] args) {
        // 普通集合的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        List<Integer> objects = Lists.newArrayListWithExpectedSize(10);// 初始化大小的集合
        Map<String, Object> hashMap = Maps.newHashMap();

        // 不可变集合的创建, immutable 集合在创建时，就确定了元素的所有信息，不需要考虑后续的扩展问题
        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> immutableSet = ImmutableSet.of("a", "b");
    }
}
