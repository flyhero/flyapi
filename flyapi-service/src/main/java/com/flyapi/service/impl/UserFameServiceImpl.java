package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.UcenterFameMapper;
import com.flyapi.dao.UcenterUserFameMapper;
import com.flyapi.model.UcenterFame;
import com.flyapi.model.UcenterUserFame;
import com.flyapi.service.api.FameService;
import com.flyapi.service.api.UserFameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class UserFameServiceImpl extends BaseServiceImpl<UcenterUserFame,UcenterUserFameMapper> implements UserFameService {
    @Autowired
    private UcenterUserFameMapper ucenterUserFameMapper;
}
