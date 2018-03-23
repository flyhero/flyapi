package com.flyapi.pojo.vo;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/27 0027 下午 2:07
 */
public class UserSubjectVo extends ShowSubjectVo{
    private CmsArticle cmsArticle;
    private ShowSubjectUserVo ucenterUser;
    private Integer rssNum;
    private boolean isRss;

    public CmsArticle getCmsArticle() {
        return cmsArticle;
    }

    public void setCmsArticle(CmsArticle cmsArticle) {
        this.cmsArticle = cmsArticle;
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
