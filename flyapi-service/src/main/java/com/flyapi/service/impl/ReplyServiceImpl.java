package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsReplyMapper;
import com.flyapi.dao.UcenterFameMapper;
import com.flyapi.model.CmsReply;
import com.flyapi.model.UcenterFame;
import com.flyapi.service.api.FameService;
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
public class ReplyServiceImpl extends BaseServiceImpl<CmsReply,CmsReplyMapper> implements ReplyService {
    @Autowired
    private CmsReplyMapper cmsReplyMapper;
}
