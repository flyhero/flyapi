package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsApply;
import com.flyapi.pojo.vo.HomePageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface HomepageApplyService extends BaseService<CmsApply> {

    CmsApply findByArticleId(Long articleId);

    PageInfo<HomePageVo> findListByExample(int pageSize, int pageNum, int status);
}
