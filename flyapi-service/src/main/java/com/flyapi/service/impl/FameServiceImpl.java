package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsLikeMapper;
import com.flyapi.dao.UcenterFameMapper;
import com.flyapi.model.CmsLike;
import com.flyapi.model.UcenterFame;
import com.flyapi.service.api.FameService;
import com.flyapi.service.api.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class FameServiceImpl extends BaseServiceImpl<UcenterFame,UcenterFameMapper> implements FameService {
    @Autowired
    private UcenterFameMapper ucenterFameMapper;
}
