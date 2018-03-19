package com.flyapi.pojo.dto;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-03-19 下午11:50
 */
public class AddNoticeDto {

    private List<Long> ids;
    private String title;
    private String content;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
