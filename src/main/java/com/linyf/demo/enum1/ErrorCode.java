package com.linyf.demo.enum1;

public enum ErrorCode implements INumberEnum{
    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    private int code;

    private String description;

    ErrorCode(int number, String description) {
        this.code = number;
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
