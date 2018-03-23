package com.flyapi.pojo.vo;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/27 0027 下午 2:07
 */
public class SubjectVo extends CmsArticle{
    private ShowSubjectVo cmsSubject;
    private ShowSubjectUserVo ucenterUser;
    private Integer rssNum;
    private boolean isRss;

    public ShowSubjectVo getCmsSubject() {
        return cmsSubject;
    }

    public void setCmsSubject(ShowSubjectVo cmsSubject) {
        this.cmsSubject = cmsSubject;
    }

    public ShowSubjectUserVo getUcenterUser() {
        return ucenterUser;
    }

    public void setUcenterUser(ShowSubjectUserVo ucenterUser) {
        this.ucenterUser = ucenterUser;
    }

    public Integer getRssNum() {
        return rssNum;
    }

    public void setRssNum(Integer rssNum) {
        this.rssNum = rssNum;
    }

    public boolean isRss() {
        return isRss;
    }

    public void setRss(boolean rss) {
        isRss = rss;
    }
}
