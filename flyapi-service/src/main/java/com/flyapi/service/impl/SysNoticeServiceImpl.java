package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.dao.SysNoticeMapper;
import com.flyapi.model.SysNotice;
import com.flyapi.pojo.dto.AddNoticeDto;
import com.flyapi.service.api.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.expression.Lists;

import java.util.Date;

/**
 * Author: qfwang
 * Date: 2018-03-19 下午11:40
 */
@Service
@Transactional
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNotice,SysNoticeMapper> implements SysNoticeService{

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    @Override
    public boolean sendMsg(AddNoticeDto noticeDto) {
        SysNotice sysNotice = new SysNotice();
        sysNotice.setCreateTime(new Date());
        if(CollectionUtils.isEmpty(noticeDto.getIds())){ //发送给全员
            sysNotice.setNoticeId(idWorker.nextId());
            sysNotice.setNoticeType((byte)0);
            sysNotice.setNoticeTitle(noticeDto.getTitle());
            sysNotice.setNoticeContent(noticeDto.getContent());

            sysNoticeMapper.insertSelective(sysNotice);
        }else {
            noticeDto.getIds().forEach(aLong -> {
                sysNotice.setNoticeId(idWorker.nextId());
                sysNotice.setNoticeType((byte)1);
                sysNotice.setUserId(aLong);
                sysNotice.setNoticeTitle(noticeDto.getTitle());
                sysNotice.setNoticeContent(noticeDto.getContent());
                sysNoticeMapper.insertSelective(sysNotice);
            });

        }

        return true;
    }
}
