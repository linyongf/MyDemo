package com.linyf.demo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>() {{
            add("a");
            add("b");
            add("c");
            add("d");
        }};



        for (String s : list) {
            if (s.equals("a")) {
                list.remove(s);
            }
        }

        System.out.println(list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
