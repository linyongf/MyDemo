package com.linyf.demo.utils;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class LangDemo1 {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
        // 1 2
        System.out.println(pair.getLeft() + " " + pair.getRight());

        Triple<Integer, Integer, Integer> triple = new ImmutableTriple<>(1,2,3);
        // 1 2 3
        System.out.println(triple.getLeft() + " " + triple.getMiddle() + " " + triple.getRight());
    }
}
