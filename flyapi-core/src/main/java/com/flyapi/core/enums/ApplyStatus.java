package com.flyapi.core.enums;

/**
 *
 * 首页申请类型
 * Author: qfwang
 * Date: 2018-03-19 下午11:08
 */
public enum ApplyStatus {
    UNKNOW("未识别",0),
    APPLYING("申请中",1),
    PASS("通过",2),
    UNPASS("未通过",3);
    private String name;
    private int value;

    ApplyStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
