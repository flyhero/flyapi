package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.util.AESUtil;
import com.flyapi.dao.SettingStoreMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.SettingStore;
import com.flyapi.model.UcenterUser;
import com.flyapi.model.UcenterUserExample;
import com.flyapi.service.api.SettingStoreService;
import com.flyapi.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UcenterUser,UcenterUserMapper> implements UserService {
    @Autowired
    private UcenterUserMapper ucenterUserMapper;

    @Autowired
    private SettingStoreMapper settingStoreMapper;

    public UcenterUser login(UcenterUser user){
        return ucenterUserMapper.findUserByUsernameAndPassword(user);
    }

    public int findUserByUsername(String username) {
        return ucenterUserMapper.findUserByUsername(username);
    }

    public UcenterUser initStore(UcenterUser user,SettingStore store){
        UcenterUser login = login(user);
        store.setUserId(login.getUserId());
        settingStoreMapper.insertSelective(store);
        return login;
    }

    //TODO 添加文章和主题统计
    @Override
    public Map<String, Object> userNumStatistics() {
        Map<String,Object> map = new HashMap<>();
        UcenterUserExample example = new UcenterUserExample();
        UcenterUserExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo((byte)0);
        Long total = ucenterUserMapper.countByExample(example);
        map.put("total",total);

        LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        Date startTime =Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date endTime =Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());
        criteria.andCreateTimeBetween(startTime,endTime);
        Long nowCount = ucenterUserMapper.countByExample(example);
        map.put("todayCount",nowCount);



        return map;
    }
}
