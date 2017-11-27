package com.flyapi.pojo.vo;

import com.flyapi.model.CmsBook;

/**
 * Author: qfwang
 * Date: 2017-11-27 上午10:36
 */
public class BookVo extends CmsBook{

    private String avatar;
    private String nickName;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
