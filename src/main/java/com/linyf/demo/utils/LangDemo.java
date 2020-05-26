package com.linyf.demo.utils;

import org.apache.commons.lang3.StringUtils;

public class LangDemo {
    public static void main(String[] args) {
        // isEmpty的实现 cs == null || cs.length() == 0; return true
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(" "));

        /**
         *  源码：
         * public static boolean isBlank(CharSequence cs) {
         *         int strLen = length(cs);  =======> cs == null ? 0 : cs.length();
         *         if (strLen == 0) {
         *             return true;
         *         } else {
         *             for(int i = 0; i < strLen; ++i) {
         *                 if (!Character.isWhitespace(cs.charAt(i))) {
         *                     return false;
         *                 }
         *             }
         *             return true;
         *         }
         *     }
         */
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
    }
}
