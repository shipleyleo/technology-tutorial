package com.leo.example.commonutils.staticdata;

import com.leo.example.commonutils.enums.IValueEnum;

import java.io.Serializable;

public class CodeItemVo implements IValueEnum<String>, Serializable {
    private String value;
    private String name;

    public CodeItemVo() {
    }

    public CodeItemVo(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }
}
