package com.linyf.demo.sugar;

public class VariableArguments {
    public static void main(String[] args)
    {
        aaa("zhangsan", "lisi", "wamgw");
    }

    public static void aaa(String... strs)
    {
        for (int i = 0; i < strs.length; i++)
        {
            System.out.println(strs[i]);
        }
    }
}
