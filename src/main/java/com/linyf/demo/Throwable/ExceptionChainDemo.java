package com.linyf.demo.Throwable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionChainDemo {
    public void readFile() throws MyException{
        try{
            InputStream is = new FileInputStream("demo.text");
        }catch(FileNotFoundException e){
            throw new MyException("文件在哪里", e);
        }
    }

    public void invokeReadFile() throws MyException{
        try{
            readFile();
        }catch (MyException e){
            throw new MyException("文件找不到", e);
        }
    }

    public static void main(String[] args) {
        ExceptionChainDemo demo = new ExceptionChainDemo();
        try{
            demo.invokeReadFile();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
