package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsHomepageApply;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.vo.HomePageVo;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface HomepageApplyService extends BaseService<CmsHomepageApply> {

    CmsHomepageApply findByArticleId(Long articleId);

    List<HomePageVo> findListByExample(int pageSize,int pageNum,int status);
}
