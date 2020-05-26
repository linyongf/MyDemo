package com.linyf.demo.sugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {

    }

    private static void aaa7(){
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("d:\\aaa.xml"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                // handle exception
            }
        }
    }

    private static void bbb7(){
        try (BufferedReader br = new BufferedReader(new FileReader("d:\\aaa.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception
        }
    }
}
