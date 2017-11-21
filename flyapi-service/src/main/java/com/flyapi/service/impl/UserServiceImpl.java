package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.util.AESUtil;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.UcenterUser;
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
public class UserServiceImpl extends BaseServiceImpl<UcenterUser,UcenterUserMapper> implements UserService {
    @Autowired
    private UcenterUserMapper ucenterUserMapper;

    public UcenterUser login(UcenterUser user){
        return ucenterUserMapper.findUserByUsernameAndPassword(user);
    }

    public int findUserByUsername(String username) {
        return ucenterUserMapper.findUserByUsername(username);
    }
}
