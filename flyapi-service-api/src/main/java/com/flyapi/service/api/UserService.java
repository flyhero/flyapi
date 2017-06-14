package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface UserService extends BaseService<UcenterUser> {
    UcenterUser login(UcenterUser user);
    int findUserByUsername(String username);
}
