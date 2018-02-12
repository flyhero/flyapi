package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsLike;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface LikeService extends BaseService<CmsLike> {

    List<CmsLike> findLikeArticleByUserId(Long userId);
}
