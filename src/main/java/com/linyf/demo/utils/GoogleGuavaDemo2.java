package com.linyf.demo.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GoogleGuavaDemo2 {
    public static void main(String[] args) {
        Table<String, String, Object> table = HashBasedTable.create();
        table.put("zhangsan", "xiaohong", 1);
        table.put("lisi", "cuihua", 2);
        // 1
        System.out.println(table.get("zhangsan", "xiaohong"));
    }
}
