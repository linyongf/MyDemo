package com.linyf.demo.enum1;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class EnumSetAndMapDemo {
    public static void main(String[] args) {
        System.out.println("==========EnumSet========");
        EnumSet<ErrorCode> enumSet = EnumSet.allOf(ErrorCode.class);
        for (ErrorCode errorCode : enumSet) {
            System.out.println(errorCode.name() + " - " + errorCode.getCode() + " : " +errorCode.getDescription());
        }

        System.out.println("==========EnumMap展示========");
        EnumMap<StateMachine.Signal, String> enumMap = new EnumMap(StateMachine.Signal.class);
        enumMap.put(StateMachine.Signal.RED, "红灯");
        enumMap.put(StateMachine.Signal.YELLOW, "黄灯");
        enumMap.put(StateMachine.Signal.GREEN, "绿灯");
        for (Map.Entry<StateMachine.Signal, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey().name() + " : " + entry.getValue());
        }
    }
}
