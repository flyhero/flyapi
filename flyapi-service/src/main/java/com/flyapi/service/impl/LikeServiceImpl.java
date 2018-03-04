package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsLikeMapper;
import com.flyapi.dao.CmsRssMapper;
import com.flyapi.model.CmsLike;
import com.flyapi.model.CmsRss;
import com.flyapi.service.api.LikeService;
import com.flyapi.service.api.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class LikeServiceImpl extends BaseServiceImpl<CmsLike,CmsLikeMapper> implements LikeService {
    @Autowired
    private CmsLikeMapper cmsLikeMapper;

    @Override
    public List<CmsLike> findLikeArticleByUserId(Long userId) {
        return cmsLikeMapper.findLikeArticleByUserId(userId);
    }

    @Override
    public CmsLike findByUserIdAndTargetId(CmsLike like) {
        return cmsLikeMapper.findByUserIdAndTargetId(like);
    }
}
