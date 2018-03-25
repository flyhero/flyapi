package com.flyapi.core.enums;

/**
 * 文件类型
 * Author: qfwang
 * Date: 2018-03-23 上午11:57
 */
public enum PathEnum {

    HEADER(1,"/header"),
    COVER(2,"/cover"),
    ARTICLE(3,"/article"),
    QRCODE(4,"/qrcode");


    private int type;
    private String path;

    PathEnum(int type, String path) {
        this.type = type;
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
