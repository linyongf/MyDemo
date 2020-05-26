package com.linyf.demo.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;

import java.util.BitSet;

public class CodecDemo2 {
    public static void main(String[] args) throws DecoderException {
        byte[] binaryByte= {0,1};
        byte[] bytes = URLCodec.encodeUrl(new BitSet(), binaryByte);
        for (byte b : bytes) {
            System.out.println(b);
        }

        System.out.println("=============解密==============");
        byte[] bytes1 = URLCodec.decodeUrl(bytes);
        for (byte b : bytes1) {
            System.out.println(b);
        }
    }
}
