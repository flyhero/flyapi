package com.flyapi.pojo.vo;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/27 0027 下午 2:07
 */
public class SubjectVo extends CmsArticle{
    private CmsSubject cmsSubject;
    private UcenterUser ucenterUser;

    public CmsSubject getCmsSubject() {
        return cmsSubject;
    }

    public void setCmsSubject(CmsSubject cmsSubject) {
        this.cmsSubject = cmsSubject;
    }

    public UcenterUser getUcenterUser() {
        return ucenterUser;
    }

    public void setUcenterUser(UcenterUser ucenterUser) {
        this.ucenterUser = ucenterUser;
    }
}
