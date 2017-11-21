package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.SettingStore;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface UserService extends BaseService<UcenterUser> {
    UcenterUser login(UcenterUser user);
    int findUserByUsername(String username);
    /**
     * 初始化图床设置
     * @title: initStore
     * @author flyhero <http://www.iflyapi.cn>
     * @params [user, store]
     * @return int
     * @date 2017/11/21 下午5:42
     */
    UcenterUser initStore(UcenterUser user,SettingStore store);
}
