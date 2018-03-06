package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.exception.DenyOperationException;
import com.flyapi.core.exception.TargetNotFoundException;
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

    public List<OpenSource> findAll(Long userId) {
        return openSourceMapper.findAll(userId);
    }

    @Override
    public int removeByOsId(Long osId,Long userId) {
        OpenSource openSource = openSourceMapper.selectByPrimaryKey(osId);
        if(null == openSource){
            throw new TargetNotFoundException("开源项目不存在");
        }
        if(openSource.getUserId() != userId){
            throw new DenyOperationException("你没有权限操作");
        }
        return openSourceMapper.removeByOsId(osId);
    }
}
