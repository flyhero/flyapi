package com.flyapi.web.pojo.dto;

/**
 * author: flyhero
 * Date: 2017/6/15 0015 下午 4:29
 */
public class RegisterDto {
    private String username;
    private String pw;
    private String ConfirmPw;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getConfirmPw() {
        return ConfirmPw;
    }

    public void setConfirmPw(String confirmPw) {
        ConfirmPw = confirmPw;
    }
}
