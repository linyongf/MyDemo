package com.linyf.demo.beanutils.service;

import com.linyf.demo.beanutils.entity.CopyTest1;
import com.linyf.demo.beanutils.entity.CopyTest2;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring的BeanUtils的CopyProperties方法需要对应的属性有getter和setter方法；
 * 如果存在属性完全相同的内部类，但是不是同一个内部类，即分别属于各自的内部类，则spring会认为属性不同，不会copy；
 * 最后，spring和apache的copy属性的方法源和目的参数的位置正好相反，所以导包和调用的时候都要注意一下。
 * getWriteMethod是jdk的方法，会去取set开头的方法，所以没有setter方法是不行滴。
 * 网上有人说 Spring的BeanUtils的CopyProperties方法会丢失map属性，有的公司已经禁用BeanUtils
 *
 * 测试spring BeanUtils.copyProperties属性的坑
 *
 */
public class BeanUtilsTest {
    /**
     * BeanUtils.copyProperties 方法不能将CopyTest1中的内部类复制到CopyTest2中，认为CopyTest1.InnerClass 和 CopyTest2.InnerClass 不同
     * BeanUtils.copyProperties 方法 只能复制 设置了getter和setter方法的属性
     * @param args
     */
    public static void main(String[] args) {
        CopyTest1 test1 = new CopyTest1();
        test1.outerName = "hahaha";
        test1.innerClass = new CopyTest1.InnerClass();
        test1.innerClass.InnerName = "hohoho";
        test1.clazz = new ArrayList();
        System.out.println(test1.toString());

        //不能复制内部类属性
//        CopyTest2 test2 = new CopyTest2();
//        BeanUtils.copyProperties(test1, test2);
//        System.out.println(test2.toString());

        CopyTest2 test2 = new CopyTest2();
        test2.innerClass = new CopyTest2.InnerClass();
        BeanUtils.copyProperties(test1.innerClass, test2.innerClass);
        BeanUtils.copyProperties(test1, test2);
        System.out.println(test2.toString());
    }
}
