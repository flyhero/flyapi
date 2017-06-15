package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsHomepageApplyMapper;
import com.flyapi.dao.CmsReplyMapper;
import com.flyapi.model.CmsHomepageApply;
import com.flyapi.model.CmsReply;
import com.flyapi.service.api.HomepageApplyService;
import com.flyapi.service.api.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class HomepageApplyServiceImpl extends BaseServiceImpl<CmsHomepageApply,CmsHomepageApplyMapper> implements HomepageApplyService {
    @Autowired
    private CmsHomepageApplyMapper cmsHomepageApplyMapper;
}
