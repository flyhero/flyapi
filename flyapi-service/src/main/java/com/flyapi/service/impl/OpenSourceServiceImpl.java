package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.OpenSourceMapper;
import com.flyapi.dao.SettingStoreMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.OpenSource;
import com.flyapi.model.SettingStore;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.OpenSourceService;
import com.flyapi.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2018/1/10 上午12:22
 */
@Service
@Transactional
public class OpenSourceServiceImpl extends BaseServiceImpl<OpenSource,OpenSourceMapper> implements OpenSourceService {

    @Autowired
    private OpenSourceMapper openSourceMapper;

    public List<OpenSource> findAll() {
        return openSourceMapper.findAll();
    }
}
