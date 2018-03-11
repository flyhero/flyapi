package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.dao.UcenterSocialMapper;
import com.flyapi.model.UcenterSocial;
import com.flyapi.model.UcenterSocialExample;
import com.flyapi.service.api.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-03-11 下午12:12
 */
@Service
@Transactional
public class SocialServiceImpl extends BaseServiceImpl<UcenterSocial,UcenterSocialMapper> implements SocialService{

    @Autowired
    private UcenterSocialMapper socialMapper;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public void saveOrUpdate(List<UcenterSocial> socialList,Long userId) {
        UcenterSocialExample example = new UcenterSocialExample();
        UcenterSocialExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        socialList.forEach(ucenterSocial -> {
            criteria.andSocialTypeEqualTo(ucenterSocial.getSocialType());
            List<UcenterSocial> social = socialMapper.selectByExample(example);
            if(social == null || social.size() == 0){
                ucenterSocial.setSocialId(snowflakeIdWorker.nextId());
                ucenterSocial.setUserId(userId);
                ucenterSocial.setCreateTime(new Date());
                socialMapper.insertSelective(ucenterSocial);
            }else {
                UcenterSocial social1 = social.get(0);
                social1.setSocialUrl(ucenterSocial.getSocialUrl());
                socialMapper.updateByPrimaryKeySelective(social1);
            }
        });
    }

    @Override
    public List<UcenterSocial> findAllSocial(Long userId) {
        UcenterSocialExample example = new UcenterSocialExample();
        UcenterSocialExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDeleteEqualTo((byte)0);
        return socialMapper.selectByExample(example);
    }
}
