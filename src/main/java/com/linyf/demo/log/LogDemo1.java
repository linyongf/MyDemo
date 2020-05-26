package com.linyf.demo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo1 {
    private static final Logger log = LoggerFactory.getLogger(LogDemo1.class);
    public static void main(String[] args) {
        log.debug("Processing trade with id:[{}] and symbol : [{}] ", 1, 2);
        
    }
}
