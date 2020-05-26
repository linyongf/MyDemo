package com.linyf.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class CodecDemo1 {
    public static void main(String[] args) {
        String md5Hex = DigestUtils.md5Hex("12345");
        System.out.println(md5Hex);
    }
}
