package com.linyf.demo.utils;

import org.apache.commons.codec.binary.Base64;

public class CodecDemo {
    public static void main(String[] args) {
        byte[] binaryByte= {0,1,2,3};
        String s = Base64.encodeBase64String(binaryByte);
        System.out.println(s);

        binaryByte = Base64.decodeBase64(s);
        for (byte b : binaryByte) {
            System.out.println(b);
        }
    }
}
