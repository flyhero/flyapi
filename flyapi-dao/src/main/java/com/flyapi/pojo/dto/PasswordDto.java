package com.flyapi.pojo.dto;

/**
 * Author: qfwang
 * Date: 2018-03-04 下午1:00
 */
public class PasswordDto {
    private String nowpass;
    private String pass;
    private String repass;

    public String getNowpass() {
        return nowpass;
    }

    public void setNowpass(String nowpass) {
        this.nowpass = nowpass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }
}
