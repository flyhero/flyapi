package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsRss;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface RssService extends BaseService<CmsRss> {

    List<CmsRss> findByUserIdAndSubjectId(CmsRss cmsRss);
}
