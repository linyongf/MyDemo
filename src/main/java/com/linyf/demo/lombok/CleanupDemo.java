package com.linyf.demo.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;

public class CleanupDemo {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("d:\\test.txt");
        @Cleanup
        FileInputStream fileInputStream = new FileInputStream(file);
        int len;
        byte[] bs = new byte[1024];
        while ((len = fileInputStream.read(bs))!=-1){
            System.out.println("content:" + new String(bs, 0, len));
        }
    }
}
