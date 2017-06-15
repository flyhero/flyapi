package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsSubjectMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.SubjectService;
import com.flyapi.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<CmsSubject,CmsSubjectMapper> implements SubjectService {

    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;
}
