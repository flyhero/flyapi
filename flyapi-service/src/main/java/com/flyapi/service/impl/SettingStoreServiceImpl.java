package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsLikeMapper;
import com.flyapi.dao.SettingStoreMapper;
import com.flyapi.model.CmsLike;
import com.flyapi.model.SettingStore;
import com.flyapi.service.api.LikeService;
import com.flyapi.service.api.SettingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/11/17 0009 下午 3:58
 */
@Service
@Transactional
public class SettingStoreServiceImpl extends BaseServiceImpl<SettingStore,SettingStoreMapper> implements SettingStoreService {
    @Autowired
    private SettingStoreMapper settingStoreMapper;
}
