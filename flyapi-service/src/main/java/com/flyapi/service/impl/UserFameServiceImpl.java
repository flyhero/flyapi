package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.dao.UcenterFameMapper;
import com.flyapi.dao.UcenterUserFameMapper;
import com.flyapi.model.UcenterFame;
import com.flyapi.model.UcenterUserFame;
import com.flyapi.service.api.FameService;
import com.flyapi.service.api.UserFameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class UserFameServiceImpl extends BaseServiceImpl<UcenterUserFame,UcenterUserFameMapper> implements UserFameService {
    @Autowired
    private UcenterUserFameMapper ucenterUserFameMapper;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    /**
     * 根据不同类型的操作增加声望值与记录
     * Title: addFameValue
     * params: [userId, opType]
     * return: int
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/19 0019 上午 11:35
     */
    public int addFameValue(Long userId, Integer opType) {
        UcenterUserFame userFame=new UcenterUserFame();
        userFame.setUserId(userId);
        userFame.setOpType(opType);
        int num=ucenterUserFameMapper.findCountByUserIdAndOpType(userFame);
        switch (opType){
            case 1:
                if(num < 1){
                    userFame.setId(snowflakeIdWorker.nextId());
                    userFame.setScore(2);
                    userFame.setOpDesc("登录");
                    userFame.setCreateTime(new Date());
                    ucenterUserFameMapper.insertSelective(userFame);
                    ucenterUserFameMapper.updateFameValueByUserId(userFame);
                }
                break;
            case 2:
                break;
            default:
                break;
        }

        return 0;
    }
}
